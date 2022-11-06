package cz.rimu.interestingflights.domain.usecase

import cz.rimu.interestingflights.domain.constants.Constants
import cz.rimu.interestingflights.domain.di.DispatcherModule
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.domain.repository.FlightsRepository
import cz.rimu.interestingflights.domain.utils.addDaysToDate
import cz.rimu.interestingflights.domain.utils.toString
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class FiveInterestingFlightsUseCase @Inject constructor(
    private val flightsRepository: FlightsRepository,
    @DispatcherModule.IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(startDate: Date): FlightDomain =
        withContext(coroutineDispatcher) {
            val result = flightsRepository.getFlights(
                startDate = startDate.addDaysToDate(1).toString(Constants.DD_MM_YYYY_FORMAT),
                endDate = startDate.addDaysToDate(1).toString(Constants.DD_MM_YYYY_FORMAT)
            )
            return@withContext if (result is FlightDomain.FlightDomainEntity) {
                flightsRepository.saveFlights(result.flights)
                FlightDomain.FlightDomainEntity(result.flights)
            } else {
                result
            }
        }
}
