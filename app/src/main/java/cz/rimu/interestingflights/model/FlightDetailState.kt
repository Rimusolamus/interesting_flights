package cz.rimu.interestingflights.model

import cz.rimu.interestingflights.domain.model.FlightDomain

data class FlightDetailState(
    val flight: FlightDomain.FlightDomainItem = FlightDomain.FlightDomainItem(
        "",
        "",
        "",
        "",
        "",
        0,
        "",
        "",
        "",
        "",
        "",
        ""
    ),
    val errorMessage: String = "",
    val inProgress: Boolean = false
)
