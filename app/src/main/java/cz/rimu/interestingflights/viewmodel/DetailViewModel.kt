package cz.rimu.interestingflights.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.rimu.interestingflights.domain.model.FlightDomain
import cz.rimu.interestingflights.domain.usecase.FlightDetailUseCase
import cz.rimu.interestingflights.model.FlightDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val flightDetailUseCase: FlightDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val flightId = savedStateHandle.get<String>("id")

    private val _uiState = MutableStateFlow(FlightDetailState())

    val uiState: StateFlow<FlightDetailState>
        get() = _uiState

    init {
        viewModelScope.launch {
            _uiState.value = FlightDetailState(inProgress = true)
            _uiState.value = when (val result = flightId?.let { flightDetailUseCase.invoke(it) }) {
                is FlightDomain.FlightDomainSingleEntity -> FlightDetailState(
                    result.flight
                )
                is FlightDomain.Failure -> FlightDetailState(
                    errorMessage = result.errorText
                )
                else -> {
                    FlightDetailState(errorMessage = "Unknown error")
                }
            }
        }
    }

}