package net.maiatoday.magicsprinkles.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun HideShowThingy(modifier: Modifier = Modifier) {
    var showMe by remember { mutableStateOf(false) }
    Column(modifier) {
        Button(onClick = {
            showMe = !showMe
        }) {
            if (showMe) Text("Hide") else Text("Show")
        }
        AnimatedVisibility(visible = showMe) {
            Text("😹")
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "HideShowThingy preview day")
@Composable
private fun DefaultPreview() {
    MagicSprinklesTheme {
        HideShowThingy()
    }
}