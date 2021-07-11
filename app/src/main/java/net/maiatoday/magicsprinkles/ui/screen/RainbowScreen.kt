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
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.component.MultiColorSmoothText
import net.maiatoday.magicsprinkles.ui.component.MultiColorText
import net.maiatoday.magicsprinkles.ui.component.SmoothRainbowText
import net.maiatoday.magicsprinkles.ui.component.SnappyRainbowText
import net.maiatoday.magicsprinkles.ui.component.TwoColorSmoothText
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun RainbowScreen() {
    Surface(color = MaterialTheme.colors.background) {
        var text by rememberSaveable { mutableStateOf("This ain't no disco!") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val spacer = Modifier.height(16.dp)
            Text(
                "🌈",
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Rainbow message") }
            )
            MultiColorText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = spacer)
            SnappyRainbowText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = spacer)
            TwoColorSmoothText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6,
                startColor = Color.Magenta,
                endColor = Color.Cyan,

                )
            Spacer(modifier = spacer)
            MultiColorSmoothText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h5,
                duration = 1200
            )
            Spacer(modifier = spacer)
            SmoothRainbowText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4,
                duration = 400
            )
            Spacer(modifier = spacer)
            SmoothRainbowText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4,
                duration = 1200
            )
            Spacer(modifier = spacer)
            SmoothRainbowText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4,
                duration = 6400
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "RainbowScreen preview day")
@Composable
private fun PreviewRainbowScreen() {
    MagicSprinklesTheme {
        RainbowScreen()
    }
}