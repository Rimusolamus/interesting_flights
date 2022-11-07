package cz.rimu.interestingflights.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import cz.rimu.interestingflights.R
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.ui.common.ErrorView
import cz.rimu.interestingflights.ui.common.FullScreenNoDataView
import cz.rimu.interestingflights.ui.common.FullScreenProgressBar
import cz.rimu.interestingflights.ui.common.FlightCard
import cz.rimu.interestingflights.viewmodel.FlightsViewModel
import kiwi.orbit.compose.ui.controls.Scaffold
import kiwi.orbit.compose.ui.controls.Text
import kiwi.orbit.compose.ui.controls.TopAppBar

@Composable
fun FlightsScreen(
    viewModel: FlightsViewModel,
    goToDetail: (String) -> Unit
) {

    val state by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = { FlightsAppBar() },
    ) {
        FullScreenProgressBar(state.inProgress)

        if (!state.inProgress) {
            if(state.flights.isEmpty()) {
                FullScreenNoDataView(stringResource(R.string.no_data_screen))
            } else {
                SetContentList(state.flights, it, goToDetail)
            }
        }

        if (state.errorMessage.isNotEmpty()) {
            ErrorView(state.errorMessage)
        }
    }
}

@Composable
private fun FlightsAppBar() {
    TopAppBar(
        title = { Text(stringResource(R.string.all_flights_screen)) }
    )
}

@Composable
fun SetContentList(
    flights: List<FlightDomain.FlightDomainItem>,
    paddingValues: PaddingValues,
    navigateToDetail: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        items(
            flights
        ) {
            FlightCard(flight = it, navigateToDetail)
        }

    }
}
