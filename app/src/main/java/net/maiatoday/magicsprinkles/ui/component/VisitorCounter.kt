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
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun VisitorCounter(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
) {
    var count by remember { mutableStateOf(0) }
    val numbersSlidingAnimation: AnimatedContentScope<Int>.() -> ContentTransform = {
        if (initialState > targetState) {
            slideInVertically(initialOffsetY = { it }) + fadeIn() with slideOutVertically(targetOffsetY = { -it }) + fadeOut()
        } else {
            slideInVertically(initialOffsetY = { -it }) + fadeIn() with slideOutVertically(targetOffsetY = { it }) + fadeOut()
        }
    }
    AnimatedContent(
        targetState = count,
        transitionSpec = numbersSlidingAnimation
    ) { number ->
        Text(
            modifier = modifier.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { count++ }
            ),
            text = number.toString().padStart(10, '0'),
            style = style
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "VisitorCounter preview day")
@Composable
private fun PreviewVisitorCounter() {
    MagicSprinklesTheme {
        Surface(color = MaterialTheme.colors.background) {
            VisitorCounter()
        }
    }
}

