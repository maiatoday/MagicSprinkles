package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme
import kotlin.math.pow


@ExperimentalAnimationApi
@Composable
fun Counter(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    onClick: () -> Unit,
    count: Int,
    width: Int
) {
    val displayWidth = maxOf(3, width)
    Row(
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        ),
    ) {
        for (n in displayWidth - 1 downTo 0) {
            CounterCell(
                modifier = modifier,
                style = style,
                count = (count.toDouble() / 10.0.pow(n) % 10).toInt(),
                width = 1
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CounterCell(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    count: Int,
    width: Int
) {
    val numbersSlidingAnimation: AnimatedContentScope<Int>.() -> ContentTransform = {
        if (initialState > targetState) {
            slideInVertically(initialOffsetY = { it }) + fadeIn() with slideOutVertically(
                targetOffsetY = { -it }) + fadeOut()
        } else {
            slideInVertically(initialOffsetY = { -it }) + fadeIn() with slideOutVertically(
                targetOffsetY = { it }) + fadeOut()
        }
    }
    AnimatedContent(
        targetState = count,
        transitionSpec = numbersSlidingAnimation
    ) { number ->
        Text(
            modifier = modifier,
            text = number.toString().padStart(width, '0'),
            style = style
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "Counter preview day")
@Composable
private fun PreviewCounter() {
    MagicSprinklesTheme {
        var count by remember { mutableStateOf(99999) }
        var isIncrementing by remember { mutableStateOf(true) }
        Surface(color = MaterialTheme.colors.background) {

            Column {
                Button(onClick = { if (isIncrementing) count++ else count-- }) {
                    Text("change")
                }
                Counter(
                    count = count,
                    width = 5,
                    onClick = { if (isIncrementing) count++ else count-- })
                Button(onClick = { isIncrementing = !isIncrementing }) {
                    val label = if (isIncrementing) "👇" else "👆"
                    Text(label)
                }
            }
        }
    }
}

