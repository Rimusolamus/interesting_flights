package cz.rimu.interestingflights.data.repository

import cz.rimu.interestingflights.data.constant.Constants.GENERAL_ERROR
import cz.rimu.interestingflights.data.local.datasource.ViewedFlightsLocalDataSource
import cz.rimu.interestingflights.data.remote.datasource.FlightsRemoteDataSourceImpl
import cz.rimu.interestingflights.data.remote.model.Flight
import cz.rimu.interestingflights.data.util.getStringDate
import cz.rimu.interestingflights.domain.constants.Constants
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.domain.repository.FlightsRepository
import javax.inject.Inject

class FlightsRepositoryImpl @Inject constructor(
    private val flightsRemoteDataSourceImpl: FlightsRemoteDataSourceImpl,
    private val viewedFlightsLocalDataSource: ViewedFlightsLocalDataSource
) : FlightsRepository {

    override suspend fun getFlights(
        startDate: String,
        endDate: String
    ): FlightDomain {

        val localFlights = viewedFlightsLocalDataSource.viewedFlightsByDate(startDate)
        if (localFlights.isNotEmpty()) {
            return FlightDomain.FlightDomainEntity(localFlights)
        }

        val response = flightsRemoteDataSourceImpl.getFlights(startDate, endDate)
        println(response.toString())
        println(response.data.toString())
        println(response.data?.flight.toString())
        return response.data?.flight?.let { flights ->
            FlightDomain.FlightDomainEntity(
                (flights.map {
                    getFlightDomainItem(it, response.data.currency, startDate)
                })
            )
        } ?: run {
            FlightDomain.Failure(response.errorMessage ?: GENERAL_ERROR)
        }
    }

    private fun getFlightDomainItem(flight: Flight, currency: String?, startDate: String) =
        FlightDomain.FlightDomainItem(
            id = flight.id ?: "-1",
            from = "${flight.cityFrom ?: ""} (${flight.flyFrom ?: ""})",
            to = "${flight.cityTo ?: ""} (${flight.flyTo ?: ""})",
            flyDuration = flight.flyDuration ?: "",
            distance = "${flight.distance ?: 0} KM",
            price = flight.price,
            currency = currency ?: "EUR",
            departureTime = flight.dTime.let { (it * 1000).getStringDate(Constants.DD_MM_YYYY_HH_mm_FORMAT) }
                ?: "",
            arrivalTime = flight.aTime.let { (it * 1000).getStringDate(Constants.DD_MM_YYYY_HH_mm_FORMAT) }
                ?: "",
            retrievalDate = startDate
        )


    override suspend fun getViewedFlights() = viewedFlightsLocalDataSource.viewedFlights()

    override suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>) =
        viewedFlightsLocalDataSource.saveFlights(flights)


}

