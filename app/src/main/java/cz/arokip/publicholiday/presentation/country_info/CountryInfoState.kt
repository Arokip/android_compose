package cz.arokip.publicholiday.presentation.country_info

import cz.arokip.publicholiday.domain.model.CountryInfo

data class CountryInfoState(
    val isLoading: Boolean = false,
    val countryInfo: CountryInfo? = null,
    val error: String = "",
)