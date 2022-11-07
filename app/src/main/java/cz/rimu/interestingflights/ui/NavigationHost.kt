package cz.rimu.interestingflights.ui

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cz.rimu.interestingflights.navigation.NavRoute
import cz.rimu.interestingflights.ui.common.ErrorView
import cz.rimu.interestingflights.ui.screens.DetailScreen
import cz.rimu.interestingflights.ui.screens.FlightsScreen
import cz.rimu.interestingflights.viewmodel.DetailViewModel

import cz.rimu.interestingflights.viewmodel.FlightsViewModel

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoute.Flights.path) {
        composable(route = NavRoute.Flights.path) {
            val viewModel = hiltViewModel<FlightsViewModel>()
            FlightsScreen(viewModel, goToDetail = { id ->
                val uriWithId = Uri.encode(id)
                navController.navigate(NavRoute.Detail.createRoute(uriWithId))
            })
        }
        composable(route = NavRoute.Detail.path) {
            val viewModel = hiltViewModel<DetailViewModel>()
            DetailScreen(viewModel, backToMain = { navController.popBackStack() })
        }
    }

}