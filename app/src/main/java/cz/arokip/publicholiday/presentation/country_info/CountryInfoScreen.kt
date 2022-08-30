package cz.arokip.publicholiday.presentation.country_info

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import cz.arokip.publicholiday.domain.model.Country

@Destination
@Composable
fun CountryInfoScreen(
    country: Country,
    viewModel: CountryInfoViewModel = hiltViewModel(),
) {

    Box(modifier = Modifier.fillMaxSize()) {
        val state = viewModel.state.value
        if (state.countryInfo != null) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text("country info: ${country.name}, ${country.countryCode}")
                Text("official name: ${state.countryInfo}")
            }
        }

        if (state.error.isNotBlank()) {
            Text(state.error, color = MaterialTheme.colorScheme.error)
        }

        if (state.isLoading) {
            Text("loading...")
        }
    }
}