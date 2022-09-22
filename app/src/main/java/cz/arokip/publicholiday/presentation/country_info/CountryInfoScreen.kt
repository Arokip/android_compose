package cz.arokip.publicholiday.presentation.country_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.presentation.country_info.components.CountryHolidaysList
import cz.arokip.publicholiday.presentation.country_info.components.CountryInfo

@Destination
@Composable
fun CountryInfoScreen(
    navigator: DestinationsNavigator,
    country: Country,
    viewModel: CountryInfoViewModel = hiltViewModel(),
) {


    Box(modifier = Modifier.fillMaxSize()) {
        val countryInfoState = viewModel.countryInfoState.value
        val nextCountryHolidaysState = viewModel.nextCountryHolidaysState.value
        val countryHolidaysInYearState = viewModel.countryHolidaysInYearState.value

        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            if (countryInfoState.countryInfo != null) {
                CountryInfo(country = country,
                    countryInfo = countryInfoState.countryInfo,
                    navigator = navigator)
            }

            if (countryInfoState.error.isNotBlank()) {
                Text(countryInfoState.error, color = MaterialTheme.colorScheme.error)
            }

            if (countryInfoState.isLoading) {
                Text("loading country info...")
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Black)
            )
            Spacer(Modifier.width(4.0.dp))
            Button(
                onClick = { viewModel.showNextHolidays.value = !viewModel.showNextHolidays.value },
            ) {
                Text(if (viewModel.showNextHolidays.value) "Next holidays from now" else "This year holidays")
            }

            if (viewModel.showNextHolidays.value) {
                CountryHolidaysList(
                    publicHolidays = nextCountryHolidaysState.publicHolidays,
                    navigator = navigator,
                )
            } else {
                CountryHolidaysList(
                    publicHolidays = countryHolidaysInYearState.publicHolidays,
                    navigator = navigator,
                )
            }


            if (nextCountryHolidaysState.error.isNotBlank()) {
                Text(countryInfoState.error, color = MaterialTheme.colorScheme.error)
            }

            if (nextCountryHolidaysState.isLoading) {
                Text("loading next country holidays...")
            }
        }

    }
}