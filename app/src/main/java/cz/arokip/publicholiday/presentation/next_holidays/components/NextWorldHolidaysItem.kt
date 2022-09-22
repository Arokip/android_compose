package cz.arokip.publicholiday.presentation.next_holidays.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cz.arokip.publicholiday.common.Constants
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.PublicHoliday
import cz.arokip.publicholiday.presentation.available_countries.components.CountryFlagImage
import cz.arokip.publicholiday.presentation.available_countries.components.SvgUrlImage
import java.util.*

@Composable
fun NextWorldHolidaysItem(
    nextWorldHoliday: PublicHoliday,
    onItemClick: (PublicHoliday) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(nextWorldHoliday) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CountryFlagImage(countryCode = nextWorldHoliday.countryCode, size = 40.dp)
        Spacer(Modifier.width(16.0.dp))
        Text(text = "${nextWorldHoliday.name} (${nextWorldHoliday.countryCode}), ${nextWorldHoliday.date}")
    }
}
