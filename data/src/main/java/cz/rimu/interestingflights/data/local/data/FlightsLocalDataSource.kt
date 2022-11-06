package cz.rimu.interestingflights.data.local.data

import cz.rimu.interestingflights.data.local.dao.FlightsDao
import cz.rimu.interestingflights.domain.model.FlightDomain
import javax.inject.Inject

class FlightsLocalDataSource @Inject constructor(private val viewedFlightsDao: FlightsDao) {
    suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>) {
        return viewedFlightsDao.saveFlights(flights)
    }

    suspend fun viewedFlightsByDate(startDate: String): List<FlightDomain.FlightDomainItem> {
        return viewedFlightsDao.flightsByDate(startDate)
    }

    suspend fun deleteAllFlights() {
        viewedFlightsDao.deleteAllFlights()
    }
}
