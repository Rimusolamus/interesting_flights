package cz.rimu.interestingflights.domain.repository

import cz.rimu.interestingflights.domain.model.FlightDomain

interface FlightsRepository {
    suspend fun getFlights(
        startDate: String,
        endDate: String
    ): FlightDomain

    suspend fun getFlightById(id: String): FlightDomain

    suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>)
    suspend fun deleteAllFlights()
}
