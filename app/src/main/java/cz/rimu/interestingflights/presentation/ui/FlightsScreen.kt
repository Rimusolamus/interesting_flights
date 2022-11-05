package cz.rimu.interestingflights.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cz.rimu.interestingflights.R
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.presentation.viewmodel.FlightsViewModel
import kiwi.orbit.compose.icons.Icons
import kiwi.orbit.compose.ui.controls.Card
import kiwi.orbit.compose.ui.controls.Scaffold
import kiwi.orbit.compose.ui.controls.Text
import kiwi.orbit.compose.ui.controls.TopAppBar

@Composable
fun FlightsScreen(
    viewModel: FlightsViewModel
) {
    LaunchedEffect(viewModel.uiState) {
        viewModel.getFlightsOffers()
    }
    val state by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = { FlightsAppBar() },
    ) {
        FullScreenProgressBar(state.inProgress)

        if (!state.inProgress) {
            SetContentList(state.flights, it)
        }

        if (state.errorMessage.isNotEmpty()) {
            FullScreenErrorView(state.errorMessage)
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
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        items(
            flights
        ) {
            FlightCard(flight = it)
        }

    }
}

@Composable
fun FlightCard(flight: FlightDomain.FlightDomainItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), elevation = 8.dp, shape = RoundedCornerShape(8.dp)

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp)

        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = Icons.AirplaneTakeoff, contentDescription = "")

                Text(
                    text = flight.from,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Text(
                    text = flight.departureTime,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = Icons.AirplaneLanding, contentDescription = "")

                Text(
                    text = flight.to,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 4.dp)
                )
                Text(
                    text = flight.arrivalTime,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = Icons.Timelapse, contentDescription = "")

                Text(
                    text = flight.flyDuration,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }
            Text(
                text = "${flight.price} ${flight.currency}",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxWidth(),
                color = MaterialTheme.colors.secondary
            )
        }

    }
}

