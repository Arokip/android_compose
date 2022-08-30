package cz.arokip.publicholiday.data.remote.dto

import cz.arokip.publicholiday.domain.model.CountryInfo

data class CountryInfoDto(
    val borders: List<BorderDto>,
    val commonName: String,
    val countryCode: String,
    val officialName: String,
    val region: String,
)

fun CountryInfoDto.toCountryInfo(): CountryInfo {
    return CountryInfo(
        borders = borders.map { it.toBorder() },
        commonName = commonName,
        countryCode = countryCode,
        officialName = officialName,
        region = region,
    )
}