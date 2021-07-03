package net.maiatoday.magicsprinkles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.maiatoday.magicsprinkles.ui.screen.*
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagicApp()
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun MagicApp() {
    MagicSprinklesTheme {
        val navController = rememberNavController()
        Navigation(navController)
    }
}




