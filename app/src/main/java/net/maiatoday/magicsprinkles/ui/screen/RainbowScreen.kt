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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import net.maiatoday.magicsprinkles.MainViewModel
import net.maiatoday.magicsprinkles.ui.component.AnotherColorShiftLoopText
import net.maiatoday.magicsprinkles.ui.component.LoopRainbowText
import net.maiatoday.magicsprinkles.ui.component.Loopy
import net.maiatoday.magicsprinkles.ui.component.MultiColorSmoothText

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
            Spacer(modifier = Modifier.height(16.dp))
            LoopRainbowText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(16.dp))
            MultiColorSmoothText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(16.dp))
            AnotherColorShiftLoopText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4,
                durationMillis = 1200
            )
            Spacer(modifier = Modifier.height(16.dp))
            Loopy(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(16.dp))
            Loopy(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4,
                duration = 1200
            )
            Spacer(modifier = Modifier.height(16.dp))
            Loopy(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4,
                duration = 6400
            )
        }
    }
}