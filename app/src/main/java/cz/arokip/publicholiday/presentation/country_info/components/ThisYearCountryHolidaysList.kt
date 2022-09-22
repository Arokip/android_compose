package cz.arokip.publicholiday.presentation.country_info.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.PublicHoliday

@Composable
fun CountryHolidaysList(
    navigator: DestinationsNavigator,
    publicHolidays: List<PublicHoliday>,
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = publicHolidays) { publicHoliday ->
            CountryHolidaysListItem(
                publicHoliday = publicHoliday,
                navigator = navigator,
            )
        }
    }
}
