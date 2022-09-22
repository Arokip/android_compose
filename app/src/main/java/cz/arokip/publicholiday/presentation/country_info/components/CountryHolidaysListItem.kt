package cz.arokip.publicholiday.presentation.country_info.components

import FixedHolidayBadge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import cz.arokip.opendataapp.ui.theme.Amber
import cz.arokip.opendataapp.ui.theme.Grey
import cz.arokip.publicholiday.domain.model.Country
import cz.arokip.publicholiday.domain.model.PublicHoliday
import cz.arokip.publicholiday.presentation.destinations.PublicHolidayInfoScreenDestination

@Composable
fun CountryHolidaysListItem(
    navigator: DestinationsNavigator,
    publicHoliday: PublicHoliday,
) {
    Row(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .background(Amber)
            .padding(horizontal = 16.dp, vertical = 2.dp)
    ) {
        // QUESTION: how to make a "divider"/vertical line through all the Eow when the row does not have fixed height?
//        Box(
//            modifier = Modifier
//                .fillMaxHeight()
//                .width(2.dp)
//                .background(Color.Black)
//        )


        Column(
            Modifier
                .weight(1f)
                .clickable {
                    navigator.navigate(PublicHolidayInfoScreenDestination(
                        holiday = publicHoliday,
                    ))
                },

            ) {
            Text(text = publicHoliday.name)
            Text(text = publicHoliday.localName, style = TextStyle(fontSize = 12.sp), color = Grey)
            Row(Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = publicHoliday.date, style = TextStyle(fontSize = 14.sp))
                FixedHolidayBadge(publicHoliday.fixed)
            }
        }
    }
}

