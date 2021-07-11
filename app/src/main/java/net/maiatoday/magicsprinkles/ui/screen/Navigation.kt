package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.maiatoday.magicsprinkles.CounterViewModel

@ExperimentalAnimationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationDirections.overview.destination) {
        composable(route = NavigationDirections.overview.destination) {
            OverviewScreen(
                onRainbowClick = { navController.navigate(NavigationDirections.rainbow.destination) },
                onSampleClick = { navController.navigate(NavigationDirections.sample.destination) },
                onBlinkClick = { navController.navigate(NavigationDirections.blink.destination) },
            )
        }
        composable(route = NavigationDirections.rainbow.destination) {
            RainbowScreen()
        }
        composable(route = NavigationDirections.sample.destination) {
            SampleScreen()
        }
        composable(route = NavigationDirections.blink.destination) {
            BlinkScreen()
        }

        composable(route = NavigationDirections.counter.destination) {
            val viewModel: CounterViewModel = hiltViewModel()
            CounterScreen(counter = viewModel.counter,
                onClick = { viewModel.onClick() })
        }
    }
}

interface NavigationCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
}

object NavigationDirections {
    val overview = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "overview"
    }
    val blink = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "blink"
    }
    val rainbow = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "rainbow"
    }
    val sample = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "sample"
    }
    val counter = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "counter"
    }
}