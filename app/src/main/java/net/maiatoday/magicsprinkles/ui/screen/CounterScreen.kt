package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@Composable
fun CounterScreen(counter: StateFlow<Int>, onClick: () -> Unit = {}) {

}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "CounterScreen preview day")
@Composable
private fun PreviewCounterScreen() {
    MagicSprinklesTheme {
        CounterScreen(MutableStateFlow(0))
    }
}