package net.maiatoday.magicsprinkles.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun FadeButton(modifier: Modifier = Modifier, content: @Composable() () -> Unit) {
    var toggleOn by remember { mutableStateOf(false) }
    val pressColor by animateColorAsState(
        if (toggleOn)
            MaterialTheme.colors.secondary
        else
            MaterialTheme.colors.secondaryVariant
    )

    Button(
        modifier = modifier,
        onClick = {
            toggleOn = !toggleOn
        },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = pressColor
        )
    ) {
        content()
    }
}