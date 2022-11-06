package cz.rimu.interestingflights.data.local.datasource

import cz.rimu.interestingflights.data.local.dao.ViewedFlightsDao
import cz.rimu.interestingflights.domain.model.FlightDomain
import javax.inject.Inject

class ViewedFlightsLocalDataSource @Inject constructor(private val viewedFlightsDao: ViewedFlightsDao) {
    suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>) {
        return viewedFlightsDao.savedViewedFlights(flights)
    }
    suspend fun viewedFlights(): List<FlightDomain.FlightDomainItem> {
        return viewedFlightsDao.viewedFlights()
    }

    suspend fun viewedFlightsByDate(startDate: String): List<FlightDomain.FlightDomainItem> {
        return viewedFlightsDao.viewedFlightsByDate(startDate)
    }

    suspend fun deleteAllFlights() {
        viewedFlightsDao.deleteAllFlights()
    }
}
