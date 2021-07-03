package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import net.maiatoday.magicsprinkles.MainViewModel

@ExperimentalAnimationApi
@Composable
fun OverviewScreen(
    viewModel: MainViewModel = viewModel(),
    navController: NavHostController
) {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { navController.navigate(NavigationDirections.rainbow.destination) }) {
                Text("🌈")
            }
            Button(onClick = { navController.navigate(NavigationDirections.sample.destination) }) {
                Text("✅")
            }
            Button(onClick = { navController.navigate(NavigationDirections.blink.destination) }) {
                Text("<blink>")
            }
        }
    }
}