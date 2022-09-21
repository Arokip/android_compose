package cz.arokip.publicholiday.presentation.public_holiday_info

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import cz.arokip.publicholiday.domain.model.PublicHoliday

@Destination
@Composable
fun PublicHolidayInfoScreen(
    holiday: PublicHoliday,
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text("holiday info: ${holiday.name}, ${holiday.countryCode}")
            Text("local name: ${holiday.localName}")
            Text("date: ${holiday.date}")
        }
    }
}