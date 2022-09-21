package cz.arokip.publicholiday.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
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
): Parcelable