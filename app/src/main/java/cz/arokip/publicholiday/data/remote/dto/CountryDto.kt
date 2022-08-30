package cz.arokip.publicholiday.data.remote.dto

import cz.arokip.publicholiday.domain.model.Country

data class CountryDto(
    val countryCode: String,
    val name: String,
)

fun CountryDto.toCountry(): Country {
    return Country(
        countryCode = countryCode,
        name = name,
    )
}