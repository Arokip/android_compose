package cz.arokip.publicholiday.presentation.available_countries.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import cz.arokip.publicholiday.common.Constants
import java.util.*

@Composable
fun CountryFlagImage(countryCode: String, size: Dp) {
    Box(
        modifier = Modifier.size(size),
    ) {
        val countryCodeLowerCase = countryCode.lowercase(Locale.getDefault())
        val svgUrl = "${Constants.BASE_URL}images/circle-flags/flags/$countryCodeLowerCase.svg"
        SvgUrlImage(svgUrl = svgUrl)
    }
}