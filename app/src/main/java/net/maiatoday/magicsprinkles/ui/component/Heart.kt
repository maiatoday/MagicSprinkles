package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Thank You https://mahendranv.github.io/posts/compose-shapes-gists/
val HeartShape = GenericShape { size, _ ->
    val h = size.height
    val w = size.width
    lineTo(0.5f*w, 	0.25f*h)
    cubicTo(0.5f*w, 	0.225f*h, 	0.458333333333333f*w, 	0.125f*h, 	0.291666666666667f*w, 	0.125f*h)
    cubicTo(0.0416666666666667f*w, 	0.125f*h, 	0.0416666666666667f*w, 	0.4f*h, 	0.0416666666666667f*w, 	0.4f*h)
    cubicTo(0.0416666666666667f*w, 	0.583333333333333f*h, 	0.208333333333333f*w, 	0.766666666666667f*h, 	0.5f*w, 	0.916666666666667f*h)
    cubicTo(0.791666666666667f*w, 	0.766666666666667f*h, 	0.958333333333333f*w, 	0.583333333333333f*h, 	0.958333333333333f*w, 	0.4f*h)
    cubicTo(0.958333333333333f*w, 	0.4f*h, 	0.958333333333333f*w, 	0.125f*h, 	0.708333333333333f*w, 	0.125f*h)
    cubicTo(0.583333333333333f*w, 	0.125f*h, 	0.5f*w, 	0.225f*h, 	0.5f*w, 	0.25f*h)
    close()
}

@Composable
fun Heart(modifier: Modifier = Modifier, color: Color = Color.Red, size: Dp = 100.dp) {

    Surface(
        shape = HeartShape,
        color = color,
        modifier = modifier
            .height(size)
            .width(size)
    ) {
        // An image view?
    }
}

@Composable
fun HeartPulse(modifier: Modifier = Modifier) {

    val infiniteTransition = rememberInfiniteTransition()
    val heartSize by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val heartColor by infiniteTransition.animateColor(
        initialValue = Color.Magenta,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Heart(modifier.scale(heartSize), heartColor)
}

@Preview
@Composable
private fun DefaultPreview() {
    Column {
        Heart()
        HeartPulse()
    }
}