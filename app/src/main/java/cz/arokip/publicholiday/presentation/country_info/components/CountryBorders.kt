package cz.arokip.publicholiday.presentation.country_info.components

import android.widget.Toast
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import cz.arokip.publicholiday.domain.model.Border
import cz.arokip.publicholiday.domain.model.toCountry
import cz.arokip.publicholiday.presentation.available_countries.AvailableCountriesViewModel
import cz.arokip.publicholiday.presentation.destinations.CountryInfoScreenDestination

@Composable
fun CountryBorders(
    navigator: DestinationsNavigator,
    borders: List<Border>,
    viewModel: AvailableCountriesViewModel = hiltViewModel(),
) {
    val availableCountryCodes = viewModel.state.value.countries.map { it.countryCode }
    BoxWithConstraints {
        val boxWithConstraintsScope = this

        val context = LocalContext.current
        LazyColumn((if (boxWithConstraintsScope.minHeight > 120.dp) Modifier.height(120.dp) else Modifier)) {
            items(items = borders) { border ->
                BorderCountryItem(border = border, onItemClick = {
                    if (availableCountryCodes.contains(border.countryCode)) {
                        navigator.navigate(CountryInfoScreenDestination(country = border.toCountry()))
                    } else {
                        Toast.makeText(context,
                            "No holidays for ${border.commonName}",
                            Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

}
