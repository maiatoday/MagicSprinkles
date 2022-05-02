package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.component.CursorVisible
import net.maiatoday.magicsprinkles.ui.component.HeartPulse
import net.maiatoday.magicsprinkles.ui.component.LifeSaver
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@Composable
fun WildCursorScreen() {
    var state by remember { mutableStateOf(true) }
    CursorVisible { if (state) HeartPulse() else LifeSaver() }
    Row(Modifier.selectableGroup(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = state,
            onClick = { state = true }
        )
        Text("💗")
        Spacer(modifier = Modifier.size(16.dp))
        RadioButton(
            selected = !state,
            onClick = { state = false }
        )
        Text("🍬")
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "Wild cursor preview day")
@Composable
private fun DefaultPreview() {
    MagicSprinklesTheme {
        WildCursorScreen()
    }
}