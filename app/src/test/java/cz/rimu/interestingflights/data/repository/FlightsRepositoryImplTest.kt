package cz.rimu.interestingflights.data.repository

import cz.rimu.interestingflights.data.constant.Constants.CONNECT_EXCEPTION
import cz.rimu.interestingflights.data.constant.NetworkStatus
import cz.rimu.interestingflights.data.local.datasource.ViewedFlightsLocalDataSource
import cz.rimu.interestingflights.data.remote.datasource.FlightsRemoteDataSourceImpl
import cz.rimu.interestingflights.data.remote.entity.FlightItem
import cz.rimu.interestingflights.data.remote.entity.FlightResponse
import cz.rimu.interestingflights.domain.entity.FlightDomainEntities
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert

import org.junit.Test

class FlightsRepositoryImplTest {

    private val flightsRemoteDataSourceImpl: FlightsRemoteDataSourceImpl = mockk(relaxed = true)
    private val viewedFlightsLocalDataSource: ViewedFlightsLocalDataSource = mockk(relaxed = true)
    private val flightsRepositoryImpl =
        FlightsRepositoryImpl(flightsRemoteDataSourceImpl, viewedFlightsLocalDataSource)
    private val startDate = "20/10/2022"
    private val endDate = "19/11/2022"

    @Test
    fun `test flightsRepository returns the viewed flights from viewedFlightsLocalDataSource is not Empty`() {
        val viewedFlights =
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
                    "20/10/2022"

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
                    "20/10/2022",
                ),
                FlightDomainEntities.FlightDomainItem(
                    "3",
                    "Prague (PRG)",
                    "Istanbul (SAW)",
                    "2h 30m",
                    "3000.46 KM",
                    64.0,
                    "EUR",
                    "08/11/2022 15:30",
                    "08/11/2022 13:00",
                    "20/10/2022",
                ),
                FlightDomainEntities.FlightDomainItem(
                    "4",
                    "London (LGW)",
                    "Vienna (VIE)",
                    "2h 00m",
                    "3000.46 KM",
                    17.0,
                    "EUR",
                    "08/11/2022 15:00",
                    "08/11/2022 13:00",
                    "20/10/2022",
                ),
                FlightDomainEntities.FlightDomainItem(
                    "5",
                    "Barcelona (BCN)",
                    "Vienna (VIE)",
                    "3h 00m",
                    "8459.46 KM",
                    17.0,
                    "EUR",
                    "07/11/2022 11:30",
                    "07/11/2022 08:30",
                    "20/10/2022",
                )
            )

        runBlocking {
            coEvery { viewedFlightsLocalDataSource.viewedFlightsByDate(startDate) } returns viewedFlights
            Assert.assertEquals(
                FlightDomainEntities.FlightDomainEntity(flights = viewedFlights),
                flightsRepositoryImpl.getFlights(startDate, endDate),
            )
        }
    }

    @Test
    fun `test flightsRepository returns flightsDomainEntity from flightsRemoteDataSourceImpl has success response`() {

        val flightsResponse: NetworkStatus<FlightResponse> =
            NetworkStatus.Success(
                FlightResponse(
                    listOf(
                        FlightItem(
                            id = "1",
                            flyDuration = "19h 45m",
                            distance = 8459.46,
                            cityFrom = "Vienna",
                            flyFrom = "VIE",
                            cityTo = "Bangkok",
                            flyTo = "BKK",
                            price = 343.0,
                            aTime = 1667485800,
                            dTime = 1667393100
                        )
                    ), currency = "EUR"
                )

            )


        val flightDomainEntity = FlightDomainEntities.FlightDomainEntity(
            listOf(
                FlightDomainEntities.FlightDomainItem(
                    "1",
                    "Vienna (VIE)",
                    "Bangkok (BKK)",
                    "19h 45m",
                    "8459.46 KM",
                    343.0,
                    "EUR",
                    "03/11/2022 16:30",
                    "02/11/2022 14:45",
                    "20/10/2022"
                )

            )
        )

        runBlocking {
            coEvery {
                flightsRemoteDataSourceImpl.getFlights(
                    startDate,
                    endDate
                )
            } returns flightsResponse
            Assert.assertEquals(
                flightDomainEntity,
                flightsRepositoryImpl.getFlights(startDate, endDate),
            )
        }

    }

    @Test
    fun `test VehicleResponse Connection failed response should return Failure`() {
        val flightFailedResponse: NetworkStatus<FlightResponse> =
            NetworkStatus.Error(CONNECT_EXCEPTION)
        val expected = FlightDomainEntities.Failure(CONNECT_EXCEPTION)
        runBlocking {
            coEvery {
                flightsRemoteDataSourceImpl.getFlights(
                    startDate,
                    endDate
                )
            } returns flightFailedResponse
            val actual = flightsRepositoryImpl.getFlights(startDate, endDate)
            Assert.assertEquals(expected, actual)
        }
    }


    @Test
    fun `test viewedFlightsLocalDataSource saveFlights is called  from flightsRepository`() {
        val viewedFlights = listOf(
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
            ),
            FlightDomainEntities.FlightDomainItem(
                "3",
                "Prague (PRG)",
                "Istanbul (SAW)",
                "2h 30m",
                "3000.46 KM",
                64.0,
                "EUR",
                "08/11/2022 15:30",
                "08/11/2022 13:00",
                "26/10/2022",
            ),
            FlightDomainEntities.FlightDomainItem(
                "4",
                "London (LGW)",
                "Vienna (VIE)",
                "2h 00m",
                "3000.46 KM",
                17.0,
                "EUR",
                "08/11/2022 15:00",
                "08/11/2022 13:00",
                "26/10/2022",
            ),
            FlightDomainEntities.FlightDomainItem(
                "5",
                "Barcelona (BCN)",
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


        runBlocking {
            flightsRepositoryImpl.saveFlights(viewedFlights)
            coVerify(exactly = 1) { viewedFlightsLocalDataSource.saveFlights(viewedFlights) }
        }
    }
}