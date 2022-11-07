package cz.rimu.interestingflights.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
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
import kiwi.orbit.compose.icons.Icons
import kiwi.orbit.compose.ui.OrbitTheme
import kiwi.orbit.compose.ui.controls.Card
import kiwi.orbit.compose.ui.controls.Text

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FlightCard(flight: FlightDomain.FlightDomainItem, navigateToDetail: (String) -> Unit) {
    Card(
        modifier = Modifier
            .clickable {
                navigateToDetail(flight.id)
            }
            .fillMaxWidth()
            .padding(8.dp), elevation = 8.dp, shape = RoundedCornerShape(8.dp)

    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp)

        ) {
            GlideImage(
                model = stringResource(R.string.image_url, flight.mapIdto),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(OrbitTheme.colors.primary.normalAlt)
            )

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