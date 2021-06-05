package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun ColourThingy(modifier: Modifier = Modifier) {
    var isPrimary by remember { mutableStateOf(false) }
    val pressColor by animateColorAsState(
        if (isPrimary)
            MaterialTheme.colors.primary
        else
            MaterialTheme.colors.secondary
    )
    Column(modifier) {
        Button(onClick = {
            isPrimary = !isPrimary
        }) {
            if (isPrimary) Text("Secondary") else Text("Primary")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(128.dp)
                .background(pressColor)
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "ColourThingy preview day")
@Composable
private fun DefaultPreview() {
    MagicSprinklesTheme {
        ColourThingy()
    }
}