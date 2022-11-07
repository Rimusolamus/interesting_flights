package cz.rimu.interestingflights.navigation

sealed class NavRoute(val path: String) {

    object Detail : NavRoute("flights/{id}") {
        fun createRoute(id: String) = "flights/$id"
    }

    object Flights : NavRoute("flights")
}


