package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.R
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme
import net.maiatoday.magicsprinkles.ui.theme.RainbowGreen

@ExperimentalAnimationApi
@Composable
fun ThemedBlinkText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current
) {
    LocalContentBlinkTag {
        Text(
            text = text,
            modifier = modifier,
            style = style
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun LocalContentBlinkTag(
    durationMillis: Int = 500,
    content: @Composable () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha: Float by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = durationMillis),
            repeatMode = RepeatMode.Reverse
        )
    )
    CompositionLocalProvider(LocalContentAlpha provides alpha) {
        content()
    }
}

@ExperimentalAnimationApi
@Composable
fun BlinkTag(
    modifier: Modifier = Modifier,
    duration: Int = 500,
    content: @Composable (modifier: Modifier) -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha: Float by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration
                1f at (duration*0.8).toInt()
                0f at duration
            },
            repeatMode = RepeatMode.Reverse
        )
    )
    content(modifier = modifier.alpha(alpha))
}

@ExperimentalAnimationApi
@Composable
fun BlinkText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    durationMillis: Int = 1000,
) {
    BlinkTag(modifier = modifier, duration = durationMillis) {
        Text(modifier = it, text = text, style = style, color = color)
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Preview(showBackground = true, name = "LocalContentBlinkTag preview day")
@Composable
private fun PreviewLocalContentBlinkTag() {
    MagicSprinklesTheme {
        LocalContentBlinkTag {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.ic_android_black_24dp),
                    contentDescription = null // decorative element
                )
                Text(text = "flashy")
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "ThemedBlinkText preview day")
@Composable
private fun PreviewBlinkText() {
    MagicSprinklesTheme {
        ThemedBlinkText(text = "blink once no twice")
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "BlinkText preview day")
@Composable
private fun PreviewBlinkTextToo() {
    MagicSprinklesTheme {
        BlinkText(
            text = "<blink>",
            color = RainbowGreen,
            modifier = Modifier.background(Color.Black)
        )
    }
}

