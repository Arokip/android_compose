package cz.arokip.publicholiday.domain.model

data class PublicHoliday(
    val counties: List<String>?,
    val countryCode: String,
    val date: String,
    val fixed: Boolean,
    val global: Boolean,
    val launchYear: Int?,
    val localName: String,
    val name: String,
    val types: List<String>
)