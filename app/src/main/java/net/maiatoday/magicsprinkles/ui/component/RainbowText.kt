package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.theme.*
import kotlin.math.round

@ExperimentalAnimationApi
@Composable
fun MultiColorText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
    startColor: Int,
    rainbow: List<Color>
) {
    Row(modifier) {
        var index = startColor
        for (character in text) {
            Text(character.toString(), color = rainbow.get(index), style = style)
            index++
            if (index == rainbow.size) index = 0
        }

    }
}

@ExperimentalAnimationApi
@Composable
fun RainbowText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = SkittlesRainbow
) {

    val infiniteTransition = rememberInfiniteTransition()
    val infinitelyAnimatedFloat = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = rainbow.size.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(),
            repeatMode = RepeatMode.Restart
        )
    )
    var startColor = infinitelyAnimatedFloat.value.toInt()
    MultiColorText(modifier, text, style, startColor, rainbow)
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "ColourThingy preview day")
@Composable
private fun DefaultPreview() {
    MagicSprinklesTheme {
        RainbowText(text = "blarghblar  ghblarghblargh")
    }
}