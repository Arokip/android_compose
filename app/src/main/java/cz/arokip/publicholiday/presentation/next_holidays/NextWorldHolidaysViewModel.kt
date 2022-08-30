package cz.arokip.publicholiday.presentation.next_holidays

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.arokip.publicholiday.common.Resource
import cz.arokip.publicholiday.domain.use_case.GetNextWorldHolidaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NextWorldHolidaysViewModel @Inject constructor(
    private val getNextWorldHolidaysUseCase: GetNextWorldHolidaysUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(NextWorldHolidaysState())
    val state: State<NextWorldHolidaysState> = _state

    init {
        getNextWorldHolidays()
    }

    private fun getNextWorldHolidays() {
        getNextWorldHolidaysUseCase().onEach { result ->
            run {
                when (result) {
                    is Resource.Error -> _state.value =
                        NextWorldHolidaysState(error = "state error: ${result.message ?: "unexpected error"}")
                    is Resource.Loading -> _state.value = NextWorldHolidaysState(isLoading = true)
                    is Resource.Success -> _state.value =
                        NextWorldHolidaysState(publicHolidays = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}