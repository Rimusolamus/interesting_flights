package cz.rimu.interestingflights.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import cz.rimu.interestingflights.R
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.ui.common.FullScreenProgressBar
import cz.rimu.interestingflights.ui.common.ErrorView
import cz.rimu.interestingflights.viewmodel.DetailViewModel
import kiwi.orbit.compose.ui.OrbitTheme
import kiwi.orbit.compose.ui.controls.ButtonPrimary
import kiwi.orbit.compose.ui.controls.Icon
import kiwi.orbit.compose.ui.controls.IconButton
import kiwi.orbit.compose.ui.controls.Scaffold
import kiwi.orbit.compose.ui.controls.Text
import kiwi.orbit.compose.ui.controls.TopAppBar

@Composable
fun DetailScreen(
    viewModel: DetailViewModel,
    backToMain: () -> Unit,
    goToUrl: (String) -> Unit
) {

    val state by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            FlightDetailAppBar(
                title = "Bruges? Nah, flight to: " + state.flight.to,
                backToMain
            )
        },
    ) {
        FullScreenProgressBar(state.inProgress)

        if (!state.inProgress) {
            FlightDetailContent(state.flight, goToUrl)
        }

        if (state.errorMessage.isNotEmpty()) {
            ErrorView(state.errorMessage)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun FlightDetailContent(flight: FlightDomain.FlightDomainItem, goToUrl: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp, start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxSize()
                .weight(1f)
        ) {
            GlideImage(
                model = stringResource(R.string.image_url, flight.mapIdto),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .background(OrbitTheme.colors.primary.normalAlt)
            )
            Text(
                text = "Flight to: " + flight.to,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Price: " + flight.price + " " + flight.currency,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        Row(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()) {
            ButtonPrimary(
                onClick = { goToUrl(flight.deepLink) },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Book now")
            }
        }
    }
}

@SuppressLint("MaterialDesignInsteadOrbitDesign")
@Composable
private fun FlightDetailAppBar(title: String, backToMain: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = backToMain) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}

