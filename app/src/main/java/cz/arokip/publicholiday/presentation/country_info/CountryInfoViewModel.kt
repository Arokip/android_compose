package cz.arokip.publicholiday.presentation.country_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.arokip.publicholiday.common.Resource
import cz.arokip.publicholiday.domain.use_case.GetCountryInfoUseCase
import cz.arokip.publicholiday.domain.use_case.GetNextCountryHolidaysUseCase
import cz.arokip.publicholiday.presentation.destinations.CountryInfoScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryInfoViewModel @Inject constructor(
    private val getCountryInfoUseCase: GetCountryInfoUseCase,
    private val getNextCountryHolidaysUseCase: GetNextCountryHolidaysUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _countryInfoState = mutableStateOf(CountryInfoState())
    val countryInfoState: State<CountryInfoState> = _countryInfoState

    private val _nextCountryHolidaysState = mutableStateOf(NextCountryHolidaysState())
    val nextCountryHolidaysState: State<NextCountryHolidaysState> = _nextCountryHolidaysState

    init {
        val countryCode =
            CountryInfoScreenDestination.argsFrom(savedStateHandle).country.countryCode
        getCountryInfo(countryCode = countryCode)
        getNextCountryHolidays(countryCode = countryCode)
    }

    private fun getCountryInfo(countryCode: String) {
        getCountryInfoUseCase(countryCode = countryCode).onEach { result ->
            run {
                when (result) {
                    is Resource.Error -> _countryInfoState.value =
                        CountryInfoState(error = "state error: ${result.message ?: "unexpected error"}")
                    is Resource.Loading -> _countryInfoState.value =
                        CountryInfoState(isLoading = true)
                    is Resource.Success -> _countryInfoState.value =
                        CountryInfoState(countryInfo = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getNextCountryHolidays(countryCode: String) {
        getNextCountryHolidaysUseCase(countryCode = countryCode).onEach { result ->
            run {
                when (result) {
                    is Resource.Error -> _nextCountryHolidaysState.value =
                        NextCountryHolidaysState(error = "state error: ${result.message ?: "unexpected error"}")
                    is Resource.Loading -> _nextCountryHolidaysState.value =
                        NextCountryHolidaysState(isLoading = true)
                    is Resource.Success -> _nextCountryHolidaysState.value =
                        NextCountryHolidaysState(publicHolidays = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}