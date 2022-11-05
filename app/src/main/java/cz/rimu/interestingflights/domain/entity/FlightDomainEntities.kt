package cz.rimu.interestingflights.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


sealed class FlightDomainEntities {
    data class FlightDomainEntity(
        val flights: List<FlightDomainItem>
    ) : FlightDomainEntities()

    @Entity(tableName = "viewedFlightsTable")
    data class FlightDomainItem(
        @PrimaryKey
        val id: String,
        val from: String,
        val to: String,
        val flyDuration: String,
        val distance: String,
        val price: Double,
        val currency: String,
        val arrivalTime: String,
        val departureTime: String,
        val retrievalDate: String,
        )

    data class Failure(val errorText: String) : FlightDomainEntities()
}

