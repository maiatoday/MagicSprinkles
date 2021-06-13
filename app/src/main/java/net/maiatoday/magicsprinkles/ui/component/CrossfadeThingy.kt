package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun CrossFadeThingy(modifier: Modifier = Modifier) {
    var currentPage by remember { mutableStateOf("A") }
    var showA by remember { mutableStateOf(true) }
    Button(onClick = {
        showA = !showA
        currentPage = if (showA) "A" else "B"
    }) {
        if (showA) Text("show B") else Text("show A")
    }
    Crossfade(targetState = currentPage) { screen ->
        when (screen) {
            "A" -> ScreenA()
            "B" -> ScreenB()
        }
    }
}

@Composable
private fun ScreenA(color:Color = MaterialTheme.colors.primaryVariant) {
    Box(modifier = Modifier
        .background(color)
        .padding(8.dp)) {
        Text("Page A", color = contentColorFor(color))
    }
}

@Composable
private fun ScreenB(color:Color = MaterialTheme.colors.secondary) {
    Box(modifier = Modifier
        .background(color)
        .padding(8.dp)) {
        Text("Page B", color = contentColorFor(color))
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