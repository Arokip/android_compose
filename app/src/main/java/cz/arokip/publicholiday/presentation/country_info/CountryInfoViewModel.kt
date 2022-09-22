package cz.arokip.publicholiday.presentation.country_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.arokip.publicholiday.common.Resource
import cz.arokip.publicholiday.domain.use_case.GetCountryHolidaysInYearUseCase
import cz.arokip.publicholiday.domain.use_case.GetCountryInfoUseCase
import cz.arokip.publicholiday.domain.use_case.GetNextCountryHolidaysUseCase
import cz.arokip.publicholiday.presentation.destinations.CountryInfoScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CountryInfoViewModel @Inject constructor(
    private val getCountryInfoUseCase: GetCountryInfoUseCase,
    private val getNextCountryHolidaysUseCase: GetNextCountryHolidaysUseCase,
    private val getCountryHolidaysInYearUseCase: GetCountryHolidaysInYearUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _countryInfoState = mutableStateOf(CountryInfoState())
    val countryInfoState: State<CountryInfoState> = _countryInfoState

    private val _nextCountryHolidaysState = mutableStateOf(NextCountryHolidaysState())
    val nextCountryHolidaysState: State<NextCountryHolidaysState> = _nextCountryHolidaysState

    private val _countryHolidaysInYearState = mutableStateOf(CountryHolidaysInYearState())
    val countryHolidaysInYearState: State<CountryHolidaysInYearState> = _countryHolidaysInYearState
    var showNextHolidays = mutableStateOf(true)

    init {
        val countryCode =
            CountryInfoScreenDestination.argsFrom(savedStateHandle).country.countryCode
        getCountryInfo(countryCode = countryCode)
        getNextCountryHolidays(countryCode = countryCode)
        getCountryHolidaysInYear(year = Calendar.getInstance().get(Calendar.YEAR).toString(), countryCode = countryCode)
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

    private fun getCountryHolidaysInYear(year:String, countryCode: String) {
        getCountryHolidaysInYearUseCase(year = year, countryCode = countryCode).onEach { result ->
            run {
                when (result) {
                    is Resource.Error -> _countryHolidaysInYearState.value =
                        CountryHolidaysInYearState(error = "state error: ${result.message ?: "unexpected error"}")
                    is Resource.Loading -> _countryHolidaysInYearState.value =
                        CountryHolidaysInYearState(isLoading = true)
                    is Resource.Success -> _countryHolidaysInYearState.value =
                        CountryHolidaysInYearState(publicHolidays = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}