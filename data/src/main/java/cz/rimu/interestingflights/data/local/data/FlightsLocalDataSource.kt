package cz.rimu.interestingflights.data.local.data

import cz.rimu.interestingflights.data.local.dao.FlightsDao
import cz.rimu.interestingflights.domain.model.FlightDomain
import javax.inject.Inject

class FlightsLocalDataSource @Inject constructor(private val flightsDao: FlightsDao) {
    suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>) {
        return flightsDao.saveFlights(flights)
    }

    suspend fun flightsByDate(startDate: String): List<FlightDomain.FlightDomainItem> {
        return flightsDao.flightsByDate(startDate)
    }

    suspend fun flightById(id: String): FlightDomain.FlightDomainItem {
        return flightsDao.flightById(id)
    }

    suspend fun deleteAllFlights() {
        flightsDao.deleteAllFlights()
    }
}
