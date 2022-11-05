package cz.rimu.interestingflights.data.repository

import cz.rimu.interestingflights.data.constant.Constants.GENERAL_ERROR
import cz.rimu.interestingflights.data.local.datasource.ViewedFlightsLocalDataSource
import cz.rimu.interestingflights.data.remote.datasource.FlightsRemoteDataSourceImpl
import cz.rimu.interestingflights.data.remote.entity.FlightItem
import cz.rimu.interestingflights.data.util.getStringDate
import cz.rimu.interestingflights.domain.constants.Constants
import cz.rimu.interestingflights.domain.entity.FlightDomainEntities
import cz.rimu.interestingflights.domain.repository.FlightsRepository
import javax.inject.Inject

class FlightsRepositoryImpl @Inject constructor(
    private val flightsRemoteDataSourceImpl: FlightsRemoteDataSourceImpl,
    private val viewedFlightsLocalDataSource: ViewedFlightsLocalDataSource
) : FlightsRepository {

    override suspend fun getFlights(
        startDate: String,
        endDate: String
    ): FlightDomainEntities {

        val localFlights = viewedFlightsLocalDataSource.viewedFlightsByDate(startDate)
        if (localFlights.isNotEmpty()) {
            return FlightDomainEntities.FlightDomainEntity(localFlights)
        }

        val response = flightsRemoteDataSourceImpl.getFlights(startDate, endDate)
        return response.data?.flights?.let { flights ->
            FlightDomainEntities.FlightDomainEntity(
                (flights.map {
                    getFlightDomainItem(it, response.data.currency, startDate)
                })
            )
        } ?: run {
            FlightDomainEntities.Failure(response.errorMessage ?: GENERAL_ERROR)
        }
    }

    private fun getFlightDomainItem(flight: FlightItem, currency: String?, startDate: String) =
        FlightDomainEntities.FlightDomainItem(
            id = flight.id ?: "-1",
            from = "${flight.cityFrom ?: ""} (${flight.flyFrom ?: ""})",
            to = "${flight.cityTo ?: ""} (${flight.flyTo ?: ""})",
            flyDuration = flight.flyDuration ?: "",
            distance = "${flight.distance ?: 0} KM",
            price = flight.price ?: 0.0,
            currency = currency ?: "EUR",
            departureTime = flight.dTime?.let { (it * 1000).getStringDate(Constants.DD_MM_YYYY_HH_mm_FORMAT) }
                ?: "",
            arrivalTime = flight.aTime?.let { (it * 1000).getStringDate(Constants.DD_MM_YYYY_HH_mm_FORMAT) }
                ?: "",
            retrievalDate = startDate
        )


    override suspend fun getViewedFlights() = viewedFlightsLocalDataSource.viewedFlights()

    override suspend fun saveFlights(flights: List<FlightDomainEntities.FlightDomainItem>) =
        viewedFlightsLocalDataSource.saveFlights(flights)


}

