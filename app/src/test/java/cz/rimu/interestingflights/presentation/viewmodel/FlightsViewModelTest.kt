package cz.rimu.interestingflights.presentation.viewmodel

import cz.rimu.interestingflights.data.constant.Constants
import cz.rimu.interestingflights.domain.entity.FlightDomainEntities
import cz.rimu.interestingflights.domain.usecase.FlightOffersUseCase
import cz.rimu.interestingflights.presentation.entity.FlightsState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Test
import java.util.*

class FlightsViewModelTest : ViewModelTest() {
    private val flightOffersUseCase: FlightOffersUseCase = mockk(relaxed = true)
    private val viewModel = FlightsViewModel(flightOffersUseCase)
    private val startDate = Date(1666296458239)

    @Test
    fun `test uiState is notified with flights when calling getFlightsOffers`() {
        val flightDomain = FlightDomainEntities.FlightDomainEntity(
            listOf(
                FlightDomainEntities.FlightDomainItem(
                    "1",
                    "Vienna (VIE)",
                    "Bangkok (BKK)",
                    "19h 00m",
                    "8459.46 KM",
                    343.0,
                    "EUR",
                    "26/10/2022 22:30",
                    "26/10/2022 03:30",
                    "26/10/2022"

                ),
                FlightDomainEntities.FlightDomainItem(
                    "2",
                    "Madrid (MAD)",
                    "Vienna (VIE)",
                    "3h 00m",
                    "8459.46 KM",
                    17.0,
                    "EUR",
                    "07/11/2022 11:30",
                    "07/11/2022 08:30",
                    "26/10/2022",

                    )
            )

        )


        runBlocking {
            coEvery { flightOffersUseCase.invoke(startDate) } returns flightDomain
            viewModel.getFlightsOffers(startDate)
            assertEquals(
                FlightsState(flights = flightDomain.flights), viewModel.uiState.value
            )
        }
    }

    @Test
    fun `test uiState is notified with failure when calling getFlightsOffers`() {
        val errorMessage = Constants.SOCKET_TIME_OUT_EXCEPTION
        val failure = FlightDomainEntities.Failure(errorMessage)
        runBlocking {
            coEvery { flightOffersUseCase.invoke(startDate) } returns failure
            viewModel.getFlightsOffers(startDate)
            assertEquals(FlightsState(errorMessage = errorMessage), viewModel.uiState.value)
        }
    }
}
