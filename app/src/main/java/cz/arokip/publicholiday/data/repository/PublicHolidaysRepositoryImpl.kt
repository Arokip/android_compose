package cz.arokip.publicholiday.data.repository

import cz.arokip.publicholiday.data.remote.PublicHolidaysApi
import cz.arokip.publicholiday.data.remote.dto.CountryDto
import cz.arokip.publicholiday.data.remote.dto.CountryInfoDto
import cz.arokip.publicholiday.data.remote.dto.PublicHolidayDto
import cz.arokip.publicholiday.domain.repository.PublicHolidaysRepository
import retrofit2.http.Path
import javax.inject.Inject

class PublicHolidaysRepositoryImpl @Inject constructor(
    private val api: PublicHolidaysApi
) : PublicHolidaysRepository {

    override suspend fun getAvailableCountries(): List<CountryDto> {
        return api.getAvailableCountries()
    }

    override suspend fun getCountryInfo(countryCode: String): CountryInfoDto {
        return api.getCountryInfo(countryCode = countryCode)
    }

    override suspend fun getNextWorldHolidays(): List<PublicHolidayDto> {
        return api.getNextWorldHolidays()
    }

    override suspend fun getNextCountryHolidays(countryCode: String): List<PublicHolidayDto> {
        return api.getNextPublicHolidays(countryCode = countryCode)
    }
}