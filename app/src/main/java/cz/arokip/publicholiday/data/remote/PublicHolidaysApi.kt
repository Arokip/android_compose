package cz.arokip.publicholiday.data.remote


import cz.arokip.publicholiday.data.remote.dto.CountryDto
import cz.arokip.publicholiday.data.remote.dto.CountryInfoDto
import cz.arokip.publicholiday.data.remote.dto.PublicHolidayDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PublicHolidaysApi {

    @GET("/api/v3/AvailableCountries")
    suspend fun getAvailableCountries(): List<CountryDto>

    @GET("/api/v3/CountryInfo/{country_code}")
    suspend fun getCountryInfo(@Path(value = "country_code", encoded = true) countryCode: String): CountryInfoDto

    @GET("/api/v3/NextPublicHolidaysWorldwide")
    suspend fun getNextWorldHolidays(): List<PublicHolidayDto>

    @GET("/api/v3/NextPublicHolidays/{country_code}")
    suspend fun getNextPublicHolidays(@Path(value = "country_code", encoded = true) countryCode: String): List<PublicHolidayDto>
}