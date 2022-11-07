package cz.rimu.interestingflights.domain.usecase

import cz.rimu.interestingflights.domain.di.DispatcherModule;
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.domain.repository.FlightsRepository
import javax.inject.Inject;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.withContext

class FlightDetailUseCase @Inject constructor(
    private val flightsRepository: FlightsRepository,
    @DispatcherModule.IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(id: String): FlightDomain =
        withContext(coroutineDispatcher) {
            return@withContext flightsRepository.getFlightById(id)
        }
}