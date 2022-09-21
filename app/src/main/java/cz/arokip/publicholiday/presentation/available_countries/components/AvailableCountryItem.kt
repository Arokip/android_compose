package cz.arokip.publicholiday.presentation.available_countries.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cz.arokip.opendataapp.ui.theme.Blue
import cz.arokip.opendataapp.ui.theme.Green
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
            .padding(horizontal = 16.dp, vertical = 8.dp),
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
        Column {
            Text(text = country.name, style = TextStyle(color = MaterialTheme.colorScheme.primary, fontSize = 18.sp))
            Text(text = "code: ${country.countryCode}", style = TextStyle(color = MaterialTheme.colorScheme.secondary, fontSize = 14.sp))
        }

    }
}
