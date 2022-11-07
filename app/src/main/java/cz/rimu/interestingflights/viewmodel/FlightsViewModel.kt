package cz.rimu.interestingflights.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.domain.usecase.FiveInterestingFlightsUseCase
import cz.rimu.interestingflights.model.FlightsState
import cz.rimu.interestingflights.util.getCurrentDateTime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FlightsViewModel @Inject constructor(
    private val flightOffersUseCase: FiveInterestingFlightsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(FlightsState())

    val uiState: StateFlow<FlightsState>
        get() = _uiState

    init {
        getFlightsOffers()
    }

    fun getFlightsOffers(startDate: Date = getCurrentDateTime()) {
        viewModelScope.launch {
            _uiState.value = FlightsState(inProgress = true)
            _uiState.value = when (val result = flightOffersUseCase.invoke(startDate)) {
                is FlightDomain.FlightDomainEntity -> FlightsState(
                    result.flights
                )
                is FlightDomain.Failure -> FlightsState(
                    errorMessage = result.errorText
                )
                else -> {
                    FlightsState(errorMessage = "Unknown error")
                }
            }
        }
    }
}


