package cz.rimu.interestingflights.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cz.rimu.interestingflights.domain.model.FlightDomain

@Dao
interface ViewedFlightsDao {
    @Query("SELECT * FROM viewedFlightsTable Where retrievalDate = :startDate")
    suspend fun viewedFlightsByDate(startDate: String): List<FlightDomain.FlightDomainItem>

    @Query("SELECT * FROM viewedFlightsTable")
    suspend fun viewedFlights(): List<FlightDomain.FlightDomainItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savedViewedFlights(flights: List<FlightDomain.FlightDomainItem>)

}