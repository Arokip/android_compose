package cz.arokip.publicholiday.presentation.country_info

import cz.arokip.publicholiday.domain.model.PublicHoliday

data class CountryHolidaysInYearState(
    val isLoading: Boolean = false,
    val publicHolidays: List<PublicHoliday> = emptyList(),
    val error: String = "",
)