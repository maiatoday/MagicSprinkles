package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun OverviewScreen(
    onRainbowClick: () -> Unit = {},
    onSampleClick: () -> Unit = {},
    onBlinkClick: () -> Unit = {},
    onCounterClick: () -> Unit = {},
    onFlamesClick: () -> Unit = {},
    onWildCursorClick: () -> Unit = {},
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onRainbowClick) {
                Text("🌈")
            }
            Button(onClick = onSampleClick) {
                Text("✅")
            }
            Button(onClick = onBlinkClick) {
                Text("<blink>")
            }
            Button(onClick = onCounterClick) {
                Text("⏱")
            }
            Button(onClick = onFlamesClick) {
                Text("🔥")
            }
            Button(onClick = onWildCursorClick) {
                Text("🍬")
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "OverviewScreen preview day")
@Composable
private fun PreviewOverviewScreen() {
    MagicSprinklesTheme {
        OverviewScreen()
    }
}