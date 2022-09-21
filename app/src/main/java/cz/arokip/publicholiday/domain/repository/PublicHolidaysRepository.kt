package cz.arokip.publicholiday.domain.repository

import cz.arokip.publicholiday.data.remote.dto.CountryDto
import cz.arokip.publicholiday.data.remote.dto.CountryInfoDto
import cz.arokip.publicholiday.data.remote.dto.PublicHolidayDto


interface PublicHolidaysRepository {

    suspend fun getAvailableCountries(): List<CountryDto>

    suspend fun getCountryInfo(countryCode: String): CountryInfoDto

    suspend fun getNextWorldHolidays(): List<PublicHolidayDto>

    suspend fun getNextCountryHolidays(countryCode: String): List<PublicHolidayDto>

}