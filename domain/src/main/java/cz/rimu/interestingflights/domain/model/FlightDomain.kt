package cz.rimu.interestingflights.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


sealed class FlightDomain {
    data class FlightDomainEntity(
        val flights: List<FlightDomainItem>
    ) : FlightDomain()

    data class FlightDomainSingleEntity(
        val flight: FlightDomainItem
    ) : FlightDomain()

    @Entity(tableName = "flightsTable")
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
        val mapIdto: String,
        val deepLink: String
        )

    data class Failure(val errorText: String) : FlightDomain()
}

