package cz.arokip.publicholiday.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val countryCode: String,
    val name: String,
): Parcelable