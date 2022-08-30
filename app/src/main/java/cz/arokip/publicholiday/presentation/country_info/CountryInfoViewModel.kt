package cz.arokip.publicholiday.presentation.country_info

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.arokip.publicholiday.common.Resource
import cz.arokip.publicholiday.domain.use_case.GetCountryInfoUseCase
import cz.arokip.publicholiday.presentation.destinations.CountryInfoScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryInfoViewModel @Inject constructor(
    private val getCountryInfoUseCase: GetCountryInfoUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _state = mutableStateOf(CountryInfoState())
    val state: State<CountryInfoState> = _state

    init {
        val countryCode =
            CountryInfoScreenDestination.argsFrom(savedStateHandle).country.countryCode
        getCountryInfo(countryCode = countryCode)
    }

    private fun getCountryInfo(countryCode: String) {
        getCountryInfoUseCase(countryCode = countryCode).onEach { result ->
            run {
                when (result) {
                    is Resource.Error -> _state.value =
                        CountryInfoState(error = "state error: ${result.message ?: "unexpected error"}")
                    is Resource.Loading -> _state.value = CountryInfoState(isLoading = true)
                    is Resource.Success -> _state.value =
                        CountryInfoState(countryInfo = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}