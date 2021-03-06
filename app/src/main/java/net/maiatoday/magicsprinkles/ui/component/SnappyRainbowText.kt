package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme
import net.maiatoday.magicsprinkles.ui.theme.SkittlesRainbow

@ExperimentalAnimationApi
@Composable
fun MultiColorText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = SkittlesRainbow,
    startColor: Int = 0,
) {
    Row(modifier) {
        var index = startColor
        for (letter in text) {
            Text(letter.toString(), color = rainbow.get(index), style = style)
            index++
            if (index == rainbow.size) index = 0
        }

    }
}

@ExperimentalAnimationApi
@Composable
fun SnappyRainbowText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = SkittlesRainbow
) {
    require(rainbow.size > 0)
    val infiniteTransition = rememberInfiniteTransition()
    val colorIndex by infiniteTransition.animateValue(
        initialValue = 0,
        targetValue = rainbow.size - 1,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(),
            repeatMode = RepeatMode.Restart
        )
    )
    MultiColorText(
        text = text,
        style = style,
        modifier = modifier,
        startColor = colorIndex,
        rainbow = rainbow
    )
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "SnappyRainbowText preview day")
@Composable
private fun SnappyRainbowTextPreview() {
    MagicSprinklesTheme {
        SnappyRainbowText(text = "Snap Attack")
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "MultiColorText preview day")
@Composable
private fun MultiColorTextPreview() {
    MagicSprinklesTheme {
        MultiColorText(text = "32 Flavours")
    }
}
