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
fun Loopy(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = SkittlesRainbow,
    startColor: Int = 0,
    duration: Int = 5600
) {
    Row(modifier) {
        var index = startColor
        for (letter in text) {
            AnotherColorShiftLoopText(
                text = letter.toString(),
                style = style,
                rainbow = rainbow,
                startIndex = index,
                duration = duration
            )
            index++
            if (index == rainbow.size) index = 0
        }

    }
}

@ExperimentalAnimationApi
@Composable
fun MultiColorSmoothText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    startColorIndex: Int = 0,
    rainbow: List<Color> = SkittlesRainbow
) {
    Row(modifier) {
        var startIndex = startColorIndex
        var nextIndex = nextLoopIndex(startColorIndex, rainbow.size - 1)
        for (letter in text) {
            ColorShiftLoopText(
                text = letter.toString(),
                startColor = rainbow[startIndex],
                endColor = rainbow[nextIndex],
                style = style
            )
            startIndex = nextLoopIndex(startIndex, rainbow.size - 1)
            nextIndex = nextLoopIndex(nextIndex, rainbow.size - 1)
        }

    }
}

private fun nextLoopIndex(current: Int, max: Int) = if (current == max) 0 else current + 1

@ExperimentalAnimationApi
@Composable
fun ColorShiftLoopText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    startColor: Color,
    endColor: Color
) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = startColor,
        targetValue = endColor,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Restart
        )
    )
    Text(text = text, color = color, style = style, modifier = modifier)
}

@ExperimentalAnimationApi
@Composable
fun AnotherColorShiftLoopText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = SkittlesRainbow,
    startIndex: Int = 0,
    duration: Int
) {
    val infiniteTransition = rememberInfiniteTransition()
    val interval = duration / rainbow.size
    val color by infiniteTransition.animateColor(
        initialValue = rainbow[0],
        targetValue = rainbow.last(),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration
                delayMillis = startIndex * interval/2
                var i = 0
                for (color in rainbow) {
                    color at i
                    i = i + interval
                }
            },
            repeatMode = RepeatMode.Restart
        )
    )
    Text(text = text, color = color, style = style, modifier = modifier)
}

@ExperimentalAnimationApi
@Composable
fun LoopRainbowText(
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
@Preview(showBackground = true, name = "AllRainbowText preview day")
@Composable
private fun AllRainbowTextPreview() {
    MagicSprinklesTheme {
        LoopRainbowText(text = "loopy")
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "MultiColorSmoothText preview day")
@Composable
private fun MultiColorSmoothTextPreview() {
    MagicSprinklesTheme {
        MultiColorSmoothText(text = "shifty")
    }
}