package cz.arokip.publicholiday.presentation.available_countries

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import cz.arokip.publicholiday.presentation.available_countries.components.AvailableCountryItem
import cz.arokip.publicholiday.presentation.destinations.CountryInfoScreenDestination
import cz.arokip.publicholiday.presentation.destinations.NextWorldHolidaysScreenDestination

@RootNavGraph(start = true)
@Destination
@Composable
fun AvailableCountriesScreen(
    navigator: DestinationsNavigator,
    viewModel: AvailableCountriesViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {

        if (state.error.isNotBlank()) {
            Text(state.error, color = MaterialTheme.colorScheme.error)
        } else if (state.isLoading) {
            Text("loading...")
        } else if (state.countries.isNotEmpty()) {
            Column {
                Button(
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                        navigator.navigate(NextWorldHolidaysScreenDestination())
                    }) {
                    Text("Show next world holidays")
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    items(items = state.countries) { country ->
                        AvailableCountryItem(country = country,
                            onItemClick = {
                                navigator.navigate(CountryInfoScreenDestination(country = country))
                            }
                        )

                    }
                }

            }
        } else {
            Text("empty list")
        }

    }
}
