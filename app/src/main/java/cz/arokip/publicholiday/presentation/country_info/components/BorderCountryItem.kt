package cz.arokip.publicholiday.presentation.country_info.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.arokip.publicholiday.common.Constants
import cz.arokip.publicholiday.domain.model.Border
import cz.arokip.publicholiday.domain.model.PublicHoliday
import cz.arokip.publicholiday.presentation.available_countries.components.CountryFlagImage
import cz.arokip.publicholiday.presentation.available_countries.components.SvgUrlImage
import java.util.*

@Composable
fun BorderCountryItem(
    border: Border,
    onItemClick: (String) -> Unit,
) {
    Row(Modifier
        .padding(2.dp)
        .clickable { onItemClick(border.countryCode) }) {
        CountryFlagImage(countryCode = border.countryCode, size = 24.dp)
        Spacer(Modifier.width(8.0.dp))
        Text(border.commonName)
    }
}
