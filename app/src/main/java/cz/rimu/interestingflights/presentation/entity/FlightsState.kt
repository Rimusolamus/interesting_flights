package cz.rimu.interestingflights.presentation.entity

import cz.rimu.interestingflights.domain.entity.FlightDomainEntities

data class FlightsState(
    val flights: List<FlightDomainEntities.FlightDomainItem> = listOf(),
    val errorMessage: String = "",
    val inProgress: Boolean = false
)
