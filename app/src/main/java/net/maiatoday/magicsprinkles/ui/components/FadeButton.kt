package net.maiatoday.magicsprinkles.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun FadeButton(content: @Composable() () -> Unit) {
    val toggleOn = remember { mutableStateOf(false) }
    val pressColor by animateColorAsState(
        if (toggleOn.value)
            MaterialTheme.colors.secondary
        else
            MaterialTheme.colors.secondaryVariant
    )

    Button(
        onClick = {
            toggleOn.value = !toggleOn.value
        },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = pressColor
        )
    ) {
        content()
    }
}