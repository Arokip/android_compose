package cz.arokip.publicholiday.presentation.available_countries

import cz.arokip.publicholiday.domain.model.Country

data class AvailableCountriesState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = "",
)