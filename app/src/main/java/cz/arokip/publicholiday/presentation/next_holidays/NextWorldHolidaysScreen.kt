package cz.arokip.publicholiday.presentation.next_holidays

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import cz.arokip.publicholiday.presentation.destinations.PublicHolidayInfoScreenDestination
import cz.arokip.publicholiday.presentation.next_holidays.components.NextWorldHolidaysItem

@Destination
@Composable
fun NextHolidaysScreen(
    navigator: DestinationsNavigator,
    viewModel: NextWorldHolidaysViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    Column {
        Text("Next Public Holidays Worldwide in the next 7 days")
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items = state.publicHolidays) { publicHolidays ->
                NextWorldHolidaysItem(nextWorldHoliday = publicHolidays,
                    onItemClick = {
                        navigator.navigate(PublicHolidayInfoScreenDestination(holiday = publicHolidays))
                    }
                )

            }
        }
    }
}