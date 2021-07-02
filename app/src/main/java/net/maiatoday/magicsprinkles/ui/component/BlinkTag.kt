package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.animatedVectorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.R
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme
import net.maiatoday.magicsprinkles.ui.theme.RainbowGreen

@ExperimentalAnimationApi
@Composable
fun BlinkText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current
) {
    BlinkTag {
        Text(
            text = text,
            modifier = modifier,
            style = style
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun BlinkTag(
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
fun BlinkTextToo(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    durationMillis: Int = 500,
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
    Text(modifier = modifier.alpha(alpha), text = text, style = style, color = color)
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Preview(showBackground = true, name = "BlinkTag preview day")
@Composable
private fun PreviewBlinkTag() {
    MagicSprinklesTheme {
        BlinkTag {
            Icon(
                painter = painterResource(id = R.drawable.ic_android_black_24dp),
                contentDescription = null // decorative element
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "BlinkText preview day")
@Composable
private fun PreviewBlinkText() {
    MagicSprinklesTheme {
        BlinkText(text = "blink once no twice")
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "BlinkTextToo preview day")
@Composable
private fun PreviewBlinkTextToo() {
    MagicSprinklesTheme {
        BlinkTextToo(
            text = "<blink>",
            color = RainbowGreen,
            modifier = Modifier.background(Color.Black)
        )
    }
}

