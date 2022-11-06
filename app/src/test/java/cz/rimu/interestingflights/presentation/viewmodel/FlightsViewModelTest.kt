package cz.rimu.interestingflights.presentation.viewmodel

import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.domain.usecase.FiveInterestingFlightsUseCase
import cz.rimu.interestingflights.model.FlightsState
import cz.rimu.interestingflights.viewmodel.FlightsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Test
import java.util.*

class FlightsViewModelTest : ViewModelTest() {
    private val flightOffersUseCase: FiveInterestingFlightsUseCase = mockk(relaxed = true)
    private val viewModel = FlightsViewModel(flightOffersUseCase)
    private val startDate = Date(1666296458239)

    @Test
    fun `test uiState is notified with flights when calling getFlightsOffers`() {
        val flightDomain = FlightDomain.FlightDomainEntity(
            listOf(
                FlightDomain.FlightDomainItem(
                    "1",
                    "Vienna (VIE)",
                    "Bangkok (BKK)",
                    "19h 00m",
                    "8459.46 KM",
                    343L,
                    "EUR",
                    "26/10/2022 22:30",
                    "26/10/2022 03:30",
                    "26/10/2022",
                    "london_gb"
                ),
                FlightDomain.FlightDomainItem(
                    "2",
                    "Madrid (MAD)",
                    "Vienna (VIE)",
                    "3h 00m",
                    "8459.46 KM",
                    17L,
                    "EUR",
                    "07/11/2022 11:30",
                    "07/11/2022 08:30",
                    "26/10/2022",
                    "london_gb"
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
        val errorMessage =
            "Request timed out while trying to connect. Please ensure you have a strong signal and try again."

        val failure = FlightDomain.Failure(errorMessage)
        runBlocking {
            coEvery { flightOffersUseCase.invoke(startDate) } returns failure
            viewModel.getFlightsOffers(startDate)
            assertEquals(FlightsState(errorMessage = errorMessage), viewModel.uiState.value)
        }
    }
}
