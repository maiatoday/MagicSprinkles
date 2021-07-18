package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.component.Counter
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FlamesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "🔥")
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "FlamesScreen preview day")
@Composable
private fun PreviewFlamesScreen() {
    MagicSprinklesTheme {
        FlamesScreen()
    }
}