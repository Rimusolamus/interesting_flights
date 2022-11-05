package cz.rimu.interestingflights.presentation.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import cz.rimu.interestingflights.presentation.viewmodel.FlightsViewModel

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "flights") {
        composable(route = "flights") {
            val viewModel = hiltViewModel<FlightsViewModel>()
            FlightsScreen(viewModel)
        }
    }

}