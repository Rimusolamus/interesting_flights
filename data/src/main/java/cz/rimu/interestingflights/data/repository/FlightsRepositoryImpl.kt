package cz.rimu.interestingflights.data.repository

import com.squareup.moshi.Moshi
import cz.rimu.interestingflights.data.constant.Constants.GENERAL_ERROR
import cz.rimu.interestingflights.data.local.datasource.ViewedFlightsLocalDataSource
import cz.rimu.interestingflights.data.remote.datasource.FlightsRemoteDataSourceImpl
import cz.rimu.interestingflights.data.remote.model.Flight
import cz.rimu.interestingflights.data.remote.model.GeoIp
import cz.rimu.interestingflights.data.utils.getStringDate
import cz.rimu.interestingflights.domain.constants.Constants
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.domain.repository.FlightsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL
import javax.inject.Inject

class FlightsRepositoryImpl @Inject constructor(
    private val flightsRemoteDataSourceImpl: FlightsRemoteDataSourceImpl,
    private val viewedFlightsLocalDataSource: ViewedFlightsLocalDataSource
) : FlightsRepository {

    override suspend fun getFlights(
        startDate: String, endDate: String
    ): FlightDomain {

        val localFlights = viewedFlightsLocalDataSource.viewedFlightsByDate(startDate)
        if (localFlights.isNotEmpty()) {
            return FlightDomain.FlightDomainEntity(localFlights)
        }

        // make location look like 49.2-16.61-250km
        val geoIpLocation = getLocation()

        // clear all flights from local db as we don't need any from yesterday
        viewedFlightsLocalDataSource.deleteAllFlights()

        val response = flightsRemoteDataSourceImpl.getFlights(startDate, endDate, geoIpLocation)

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
            flyDuration = flight.flyDuration,
            distance = "${flight.distance ?: 0} KM",
            price = flight.price ?: 0L,
            currency = currency ?: "EUR",
            departureTime = flight.dTime.let { (it?.times(1000))?.getStringDate(Constants.DD_MM_YYYY_HH_mm_FORMAT) }
                ?: "",
            arrivalTime = (flight.aTime.let {
                (it?.times(1000))?.getStringDate(Constants.DD_MM_YYYY_HH_mm_FORMAT) ?: ""
            }),
            retrievalDate = startDate,
            mapIdto = flight.mapIdto ?: "",
        )

    override suspend fun getViewedFlights() = viewedFlightsLocalDataSource.viewedFlights()

    override suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>) =
        viewedFlightsLocalDataSource.saveFlights(flights)

    override suspend fun deleteAllFlights() = viewedFlightsLocalDataSource.deleteAllFlights()

    private suspend fun getLocation(): String {
        return withContext(Dispatchers.IO) {
            try {
                val client = OkHttpClient()
                val request = Request.Builder()
                    .url("https://ipinfo.io/json")
                    .build()
                val response = client.newCall(request).execute()
                val geoIp = Moshi.Builder().build().adapter(GeoIp::class.java)
                    .fromJson(response.body?.string() ?: "")
                if (geoIp?.loc.isNullOrEmpty()) "49.2-16.61-250km" else geoIp?.loc!!.replace(
                    ",",
                    "-"
                ) + "-100km"
            } catch (e: Exception) {
                "49.2-16.61-250km"
            }
        }
    }
}

