package cz.rimu.interestingflights.domain.usecase

import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.data.repository.FlightsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert

import org.junit.Test
import java.util.*

@OptIn(ExperimentalCoroutinesApi::class)
class FlightOffersUseCaseTest {

    private val flightsRepository: cz.rimu.interestingflights.data.repository.FlightsRepository = mockk(relaxed = true)

    private val testDispatcher = UnconfinedTestDispatcher()
    private val flightOffersUseCase = FiveInterestingFlightsUseCase(
        flightsRepository,
        testDispatcher
    )

    @Test
    fun `test repository getFlights is called from FlightOffersUseCase with the correct parameters`() {
        val currentDate = Date(1666296458239)

        runBlocking {
            flightOffersUseCase.invoke(currentDate)
            coVerify(exactly = 1) { flightsRepository.getFlights("20/10/2022", "19/11/2022") }
        }
    }

    @Test
    fun `test flightOffersUseCase returns filtered flights list when calling repository getFlights`() {
        val currentDate = Date(1666296458239)

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
                    "26/10/2022"

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
                ),
                FlightDomain.FlightDomainItem(
                    "3",
                    "Prague (PRG)",
                    "Istanbul (SAW)",
                    "2h 30m",
                    "3000.46 KM",
                    64L,
                    "EUR",
                    "08/11/2022 15:30",
                    "08/11/2022 13:00",
                    "26/10/2022",
                ),
                FlightDomain.FlightDomainItem(
                    "4",
                    "London (LGW)",
                    "Vienna (VIE)",
                    "2h 00m",
                    "3000.46 KM",
                    17L,
                    "EUR",
                    "08/11/2022 15:00",
                    "08/11/2022 13:00",
                    "26/10/2022",
                ),
                FlightDomain.FlightDomainItem(
                    "5",
                    "Barcelona (BCN)",
                    "Vienna (VIE)",
                    "3h 00m",
                    "8459.46 KM",
                    17L,
                    "EUR",
                    "07/11/2022 11:30",
                    "07/11/2022 08:30",
                    "26/10/2022",
                ), FlightDomain.FlightDomainItem(
                    "6",
                    "Vienna (VIE)",
                    "Dubai (DXB)",
                    "5h 30m",
                    "9000.46 KM",
                    73L,
                    "EUR",
                    "07/11/2022 22:05",
                    "07/11/2022 13:35",
                    "26/10/2022",
                ), FlightDomain.FlightDomainItem(
                    "7",
                    "Katowice (KTW)",
                    "New York (JFK)",
                    "16h 45m",
                    "11500.46 KM",
                    250L,
                    "EUR",
                    "16/11/2022 00:00",
                    "15/11/2022 13:15",
                    "26/10/2022"
                )
            )

        )


        val filteredFlights = FlightDomain.FlightDomainEntity(
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
                    "26/10/2022"

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
                ),
                FlightDomain.FlightDomainItem(
                    "3",
                    "Prague (PRG)",
                    "Istanbul (SAW)",
                    "2h 30m",
                    "3000.46 KM",
                    64L,
                    "EUR",
                    "08/11/2022 15:30",
                    "08/11/2022 13:00",
                    "26/10/2022",
                ),
                FlightDomain.FlightDomainItem(
                    "4",
                    "London (LGW)",
                    "Vienna (VIE)",
                    "2h 00m",
                    "3000.46 KM",
                    17L,
                    "EUR",
                    "08/11/2022 15:00",
                    "08/11/2022 13:00",
                    "26/10/2022",
                ),
                FlightDomain.FlightDomainItem(
                    "5",
                    "Barcelona (BCN)",
                    "Vienna (VIE)",
                    "3h 00m",
                    "8459.46 KM",
                    17L,
                    "EUR",
                    "07/11/2022 11:30",
                    "07/11/2022 08:30",
                    "26/10/2022",
                )
            )

        )
        runBlocking {
            coEvery {
                flightsRepository.getFlights(
                    "20/10/2022",
                    "19/11/2022"
                )
            } returns flightDomain

            coEvery { flightsRepository.getViewedFlights() } returns listOf()
            Assert.assertEquals(flightOffersUseCase.invoke(currentDate), filteredFlights)
        }
    }

}