import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cz.arokip.opendataapp.ui.theme.Lime
import cz.arokip.opendataapp.ui.theme.Red

@Composable
fun FixedHolidayBadge(
    isFixed: Boolean,
) {
    Column {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .background(if (isFixed) Lime else Red)
                .padding(horizontal = 6.dp, vertical = 1.dp)
        ) {
            Text(if (isFixed) "FIXED" else "FLEXIBLE", style = TextStyle(fontSize = 12.sp))
        }
    }
}