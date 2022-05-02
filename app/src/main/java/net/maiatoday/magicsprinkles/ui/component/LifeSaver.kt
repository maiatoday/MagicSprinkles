package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.theme.PastelRainbow
import net.maiatoday.magicsprinkles.ui.theme.SkittlesRainbow

@Composable
fun LifeSaver(rainbow: List<Color> = SkittlesRainbow) {
    val color by rainbowState(rainbow = rainbow, duration = 2000)
    val highlight by rainbowState(PastelRainbow, 2000)
    val infiniteTransition = rememberInfiniteTransition()
    val arcAngle1 by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 180F,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    val arcAngle2 by infiniteTransition.animateFloat(
        initialValue = 180F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )
    Canvas(
        modifier = Modifier
            .size(80.dp)

    ) {
        drawCircle(
            color = color,
            radius = 40.dp.toPx(),
            style = Stroke(width = 40.dp.toPx(), cap = StrokeCap.Round)
        )
        drawCircle(
            color = highlight,
            radius = 24.dp.toPx(),
            style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
        )
        drawCircle(
            color = highlight,
            radius = 55.dp.toPx(),
            style = Stroke(width = 2.dp.toPx(), cap = StrokeCap.Round)
        )
        drawArc(
            color = highlight,
            startAngle = arcAngle1,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round),
        )
        drawArc(
            color = highlight,
            startAngle = arcAngle2,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round),
        )
    }
}

@Composable
fun rainbowState(
    rainbow: List<Color> = SkittlesRainbow,
    duration: Int = 3000
): State<Color> {
    val infiniteTransition = rememberInfiniteTransition()
    val interval = duration / rainbow.size
    return infiniteTransition.animateColor(
        initialValue = rainbow[0],
        targetValue = rainbow.last(),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration
                var i = 0
                for (color in rainbow) {
                    color at i
                    i += interval
                }
            },
            repeatMode = RepeatMode.Restart
        )
    )
}

@Preview
@Composable
private fun DefaultPreview() {
    Surface(modifier = Modifier.size(200.dp)) {
        Box(modifier = Modifier.size(80.dp), contentAlignment = Alignment.Center) {
            LifeSaver()
        }
    }
}