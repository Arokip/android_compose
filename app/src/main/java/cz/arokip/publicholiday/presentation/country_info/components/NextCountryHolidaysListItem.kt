package cz.arokip.publicholiday.presentation.country_info.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.arokip.publicholiday.common.Constants
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.CountryInfo
import cz.arokip.publicholiday.domain.model.PublicHoliday
import cz.arokip.publicholiday.presentation.available_countries.components.AvailableCountryItem
import cz.arokip.publicholiday.presentation.available_countries.components.SvgUrlImage
import cz.arokip.publicholiday.presentation.country_info.NextCountryHolidaysState
import cz.arokip.publicholiday.presentation.destinations.CountryInfoScreenDestination
import java.util.*

@Composable
fun NextCountryHolidaysListItem(
    publicHoliday: PublicHoliday,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
    ) {
        Text(text = publicHoliday.name)
        Text(text = publicHoliday.date)
    }

}
