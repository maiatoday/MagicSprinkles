package net.maiatoday.magicsprinkles.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun TransitionThingy(modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isExpanded, label = "color and size")
    val size by transition.animateDp(label = "size") { state ->
        if (state)
            56.dp
        else
            24.dp
    }
    val pressColor by transition.animateColor(label = "color") { state ->
        if (state)
            MaterialTheme.colors.primary
        else
            MaterialTheme.colors.secondary

    }
    Column(modifier) {
        Button(onClick = {
            isExpanded = !isExpanded
        }) {
            if (isExpanded) Text("Shrink") else Text("Grow")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(size)
                .background(pressColor)
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "TransitionThingy preview day")
@Composable
private fun DefaultPreview() {
    MagicSprinklesTheme {
        TransitionThingy()
    }
}