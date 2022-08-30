package cz.arokip.publicholiday.data.remote.dto

import cz.arokip.publicholiday.domain.model.Border

data class BorderDto(
    val borders: Any?,
    val commonName: String,
    val countryCode: String,
    val officialName: String,
    val region: String,
)

fun BorderDto.toBorder(): Border {
    return Border(
        commonName = commonName,
        countryCode = countryCode,
        officialName = officialName,
        region = region,
    )
}