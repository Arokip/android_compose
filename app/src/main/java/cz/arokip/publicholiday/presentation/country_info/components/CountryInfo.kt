package cz.arokip.publicholiday.presentation.country_info.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.CountryInfo

@Composable
fun CountryInfo(
    navigator: DestinationsNavigator,
    country: Country,
    countryInfo: CountryInfo,
) {
    Column(Modifier
        .padding(top = 16.dp, start = 16.dp)
        .fillMaxWidth()) {
        Text("${country.name} (${country.countryCode})", style = TextStyle(fontSize = 18.sp))
        Text(countryInfo.officialName)
        Spacer(Modifier.height(16.0.dp))
        if (countryInfo.borders.isNotEmpty()) {
            CountryBorders(borders = countryInfo.borders, navigator = navigator)
        }
    }
}
