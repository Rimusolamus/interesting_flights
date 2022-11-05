package cz.rimu.interestingflights.domain.usecase

import cz.rimu.interestingflights.data.util.addDaysToDate
import cz.rimu.interestingflights.data.util.toString
import cz.rimu.interestingflights.domain.constants.Constants
import cz.rimu.interestingflights.domain.di.DispatcherModule
import cz.rimu.interestingflights.domain.entity.FlightDomainEntities
import cz.rimu.interestingflights.domain.repository.FlightsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject


class FlightOffersUseCase @Inject constructor(
    private val flightsRepository: FlightsRepository,
    @DispatcherModule.IoDispatcher private val coroutineDispatcher: CoroutineDispatcher

) {
    suspend operator fun invoke(startDate: Date): FlightDomainEntities =
        withContext(coroutineDispatcher) {
            val result = flightsRepository.getFlights(
                startDate = startDate.toString(Constants.DD_MM_YYYY_FORMAT),
                endDate = startDate.addDaysToDate(30).toString(Constants.DD_MM_YYYY_FORMAT)
            )
            return@withContext if (result is FlightDomainEntities.FlightDomainEntity) {
                val viewedFlights = flightsRepository.getViewedFlights()
                val filteredFlights = result.flights.filter {
                    it.retrievalDate in viewedFlights.map { item -> item.retrievalDate }
                            || it.id !in viewedFlights.map { item -> item.id }
                }.take(5)
                flightsRepository.saveFlights(filteredFlights)
                FlightDomainEntities.FlightDomainEntity(filteredFlights)
            } else {
                result
            }
        }
}
