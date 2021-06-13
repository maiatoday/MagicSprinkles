package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.MainViewModel
import net.maiatoday.magicsprinkles.ui.component.ColourThingy
import net.maiatoday.magicsprinkles.ui.component.HideShowThingy
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@ExperimentalAnimationApi
@Composable
fun RainbowScreen(
    viewModel: MainViewModel = viewModel(),
    navController: NavHostController
) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "🌈",
                modifier = Modifier.padding(8.dp)
            )
            ColourThingy(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
            HideShowThingy(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
        }
    }
}