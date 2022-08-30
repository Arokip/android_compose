package cz.arokip.publicholiday.presentation.available_countries.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest


@Composable
fun SvgUrlImage(svgUrl: String) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .decoderFactory(SvgDecoder.Factory())
            .data(svgUrl)
            .build()
    )
    Image(
        painter = painter,
        contentDescription = null
    )
}