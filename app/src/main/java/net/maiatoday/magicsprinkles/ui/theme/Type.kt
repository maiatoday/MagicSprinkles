package net.maiatoday.magicsprinkles.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import net.maiatoday.magicsprinkles.R


val ComicNeue = FontFamily(
    Font(R.font.comic_neue_regular),
    Font(R.font.comic_neue_bold, FontWeight.Bold),
    Font(R.font.comic_neue_light, FontWeight.Light)
)

val SourceSerif = FontFamily(
    Font(R.font.source_serif_pro_regular),
    Font(R.font.source_serif_pro_bold, FontWeight.Bold),
    Font(R.font.source_serif_pro_light, FontWeight.Light),
    Font(R.font.source_serif_pro_black, FontWeight.Black),
    Font(R.font.source_serif_pro_extra_light, FontWeight.ExtraLight),
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = SourceSerif,
    h3 = TextStyle(fontFamily = ComicNeue)
)
