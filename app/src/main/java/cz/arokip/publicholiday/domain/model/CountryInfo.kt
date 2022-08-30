package cz.arokip.publicholiday.domain.model

data class CountryInfo(
    val borders: List<Border>,
    val commonName: String,
    val countryCode: String,
    val officialName: String,
    val region: String
)