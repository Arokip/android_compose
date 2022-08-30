package cz.arokip.publicholiday.presentation.next_holidays

import cz.arokip.publicholiday.domain.model.PublicHoliday

data class NextWorldHolidaysState(
    val isLoading: Boolean = false,
    val publicHolidays: List<PublicHoliday> = emptyList(),
    val error: String = "",
)