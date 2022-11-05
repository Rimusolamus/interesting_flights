package cz.rimu.interestingflights.presentation.entity

import cz.rimu.interestingflights.domain.model.FlightDomain

data class FlightsState(
    val flights: List<FlightDomain.FlightDomainItem> = listOf(),
    val errorMessage: String = "",
    val inProgress: Boolean = false
)
