package cz.rimu.interestingflights.domain.repository

import cz.rimu.interestingflights.domain.model.FlightDomain

interface FlightsRepository {
    suspend fun getFlights(
        startDate: String,
        endDate: String
    ): FlightDomain

    suspend fun getViewedFlights(): List<FlightDomain.FlightDomainItem>
    suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>)
}
