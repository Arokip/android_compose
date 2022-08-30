package cz.arokip.publicholiday.presentation.available_countries.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.arokip.publicholiday.common.Constants
import cz.arokip.publicholiday.domain.model.Country
import java.util.*

@Composable
fun AvailableCountryItem(
    country: Country,
    onItemClick: (Country) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(country) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(40.dp),
        ) {
            val countryCodeLowerCase = country.countryCode.lowercase(Locale.getDefault())
            val svgUrl = "${Constants.BASE_URL}images/circle-flags/flags/$countryCodeLowerCase.svg"
            SvgUrlImage(svgUrl = svgUrl)
        }
        Spacer(Modifier.width(16.0.dp))
        Text(text = "${country.name} (${country.countryCode})")
    }
}
