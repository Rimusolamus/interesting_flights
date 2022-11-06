package cz.rimu.interestingflights.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


sealed class FlightDomain {
    data class FlightDomainEntity(
        val flights: List<FlightDomainItem>
    ) : FlightDomain()

    @Entity(tableName = "viewedFlightsTable")
    data class FlightDomainItem(
        @PrimaryKey
        val id: String,
        val from: String,
        val to: String,
        val flyDuration: String,
        val distance: String,
        val price: Long,
        val currency: String,
        val arrivalTime: String,
        val departureTime: String,
        val retrievalDate: String,
        val mapIdto: String
        )

    data class Failure(val errorText: String) : FlightDomain()
}

