package cz.rimu.interestingflights.model

import cz.rimu.interestingflights.domain.model.FlightDomain

data class FlightsState(
    val flights: List<FlightDomain.FlightDomainItem> = listOf(),
    val errorMessage: String = "",
    val inProgress: Boolean = false
)
