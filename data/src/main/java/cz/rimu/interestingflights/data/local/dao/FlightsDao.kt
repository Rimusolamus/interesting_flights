package cz.rimu.interestingflights.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cz.rimu.interestingflights.domain.model.FlightDomain

@Dao
interface FlightsDao {
    @Query("SELECT * FROM flightsTable Where retrievalDate = :startDate")
    suspend fun flightsByDate(startDate: String): List<FlightDomain.FlightDomainItem>

    @Query("SELECT * FROM flightsTable Where id = :id")
    suspend fun flightById(id: String): FlightDomain.FlightDomainItem

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFlights(flights: List<FlightDomain.FlightDomainItem>)

    @Query("DELETE FROM flightsTable")
    suspend fun deleteAllFlights()
}