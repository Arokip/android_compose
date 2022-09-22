package cz.arokip.publicholiday.presentation.public_holiday_info

import FixedHolidayBadge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import cz.arokip.publicholiday.common.Constants
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.PublicHoliday
import cz.arokip.publicholiday.presentation.available_countries.components.CountryFlagImage
import cz.arokip.publicholiday.presentation.available_countries.components.SvgUrlImage
import java.util.*

@Destination
@Composable
fun PublicHolidayInfoScreen(
    holiday: PublicHoliday,
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            CountryFlagImage(countryCode = holiday.countryCode, size = 24.dp)
            // TODO: country name
            // QUESTION: how to get a country info from api and do not duplicate code from country info screen (state/usecase/viewmodel)
            Text("(${holiday.countryCode})")
            Text("holiday info: ${holiday.name}")
            Text("local name: ${holiday.localName}")
            Text("date: ${holiday.date}")
            FixedHolidayBadge(isFixed = holiday.fixed)
        }
    }
}