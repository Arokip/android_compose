package cz.arokip.publicholiday.presentation.available_countries

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.arokip.publicholiday.common.Resource
import cz.arokip.publicholiday.domain.use_case.GetAvailableCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AvailableCountriesViewModel @Inject constructor(
    private val getAvailableCountriesUseCase: GetAvailableCountriesUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(AvailableCountriesState())
    val state: State<AvailableCountriesState> = _state

    init {
        getAvailableCountries()
    }

    private fun getAvailableCountries() {
        getAvailableCountriesUseCase().onEach { result ->
            run {
                when (result) {
                    is Resource.Error -> _state.value =
                        AvailableCountriesState(error = result.message ?: "unexpected error")
                    is Resource.Loading -> _state.value = AvailableCountriesState(isLoading = true)
                    is Resource.Success -> _state.value = AvailableCountriesState(countries = result.data?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}