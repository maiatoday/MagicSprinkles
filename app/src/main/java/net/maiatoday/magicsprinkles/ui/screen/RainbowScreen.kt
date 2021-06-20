package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import net.maiatoday.magicsprinkles.MainViewModel
import net.maiatoday.magicsprinkles.ui.component.*

@ExperimentalAnimationApi
@Composable
fun RainbowScreen(
    viewModel: MainViewModel = viewModel(),
    navController: NavHostController
) {
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