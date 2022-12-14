package cz.arokip.publicholiday.domain.model

data class Border(
    val commonName: String,
    val countryCode: String,
    val officialName: String,
    val region: String
)

fun Border.toCountry(): Country {
    return Country(
        countryCode = countryCode,
        name = commonName,
    )
}