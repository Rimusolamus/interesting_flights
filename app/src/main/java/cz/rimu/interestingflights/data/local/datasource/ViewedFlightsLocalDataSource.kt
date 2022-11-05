package cz.rimu.interestingflights.data.local.datasource

import cz.rimu.interestingflights.data.local.dao.ViewedFlightsDao
import cz.rimu.interestingflights.domain.entity.FlightDomainEntities
import javax.inject.Inject

class ViewedFlightsLocalDataSource @Inject constructor(private val viewedFlightsDao: ViewedFlightsDao) {
    suspend fun saveFlights(flights: List<FlightDomainEntities.FlightDomainItem>) {
        return viewedFlightsDao.savedViewedFlights(flights)
    }
    suspend fun viewedFlights(): List<FlightDomainEntities.FlightDomainItem> {
        return viewedFlightsDao.viewedFlights()
    }

    suspend fun viewedFlightsByDate(startDate: String): List<FlightDomainEntities.FlightDomainItem> {
        return viewedFlightsDao.viewedFlightsByDate(startDate)
    }
}
