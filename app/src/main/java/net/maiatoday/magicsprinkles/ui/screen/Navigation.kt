package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NamedNavArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@ExperimentalAnimationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationDirections.overview.destination) {
        composable(route = NavigationDirections.overview.destination) {
            OverviewScreen(navController = navController)
        }
        composable(route = NavigationDirections.rainbow.destination) {
            RainbowScreen(navController = navController)
        }
        composable(route = NavigationDirections.sample.destination) {
            SampleScreen(navController = navController)
        }
        composable(route = NavigationDirections.blink.destination) {
            BlinkScreen(navController = navController)
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
}