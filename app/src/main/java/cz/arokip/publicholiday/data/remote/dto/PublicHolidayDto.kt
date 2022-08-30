package cz.arokip.publicholiday.data.remote.dto

import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.PublicHoliday

data class PublicHolidayDto(
    val counties: List<String>?,
    val countryCode: String,
    val date: String,
    val fixed: Boolean,
    val global: Boolean,
    val launchYear: Int?,
    val localName: String,
    val name: String,
    val types: List<String>,
)


fun PublicHolidayDto.toPublicHoliday(): PublicHoliday {
    return PublicHoliday(
        counties = counties,
        countryCode = countryCode,
        date = date,
        fixed = fixed,
        global = global,
        launchYear = launchYear,
        localName = localName,
        name = name,
        types = types,
    )
}

fun PublicHoliday.toCountry(): Country {
    return Country(
        countryCode = countryCode,
        name = name,
    )
}