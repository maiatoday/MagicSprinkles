package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme
import net.maiatoday.magicsprinkles.ui.theme.PastelRainbow

@ExperimentalAnimationApi
@Composable
fun SmoothRainbowText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = PastelRainbow,
    startColor: Int = 0,
    duration: Int = 1200
) {
    Row(modifier) {
        var index = startColor
        for (letter in text) {
            MultiColorSmoothText(
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
fun TwoColorSmoothText(
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
fun MultiColorSmoothText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = PastelRainbow,
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
                delayMillis = startIndex * interval / 2
                var i = 0
                for (color in rainbow) {
                    color at i
                    i += interval
                }
            },
            repeatMode = RepeatMode.Restart
        )
    )
    Text(text = text, color = color, style = style, modifier = modifier)
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "TwoColorSmoothText preview day")
@Composable
private fun TwoColorSmoothTextPreview() {
    MagicSprinklesTheme {
        TwoColorSmoothText(
            text = "Two Tone",
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.h4,
            startColor = PastelRainbow[0],
            endColor = PastelRainbow[2]
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "MultiColorSmoothText preview day")
@Composable
private fun MultiColorSmoothTextPreview() {
    MagicSprinklesTheme {
        MultiColorSmoothText(
            text = "Mad World",
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.h4,
            duration = 1200
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "SmoothRainbowText preview day")
@Composable
private fun SmoothRainbowTextPreview() {
    MagicSprinklesTheme {
        SmoothRainbowText(
            text = "Smooth Operator",
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.h4,
            duration = 1200
        )
    }
}