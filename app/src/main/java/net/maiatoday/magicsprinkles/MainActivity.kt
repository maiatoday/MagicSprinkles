package net.maiatoday.magicsprinkles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import net.maiatoday.magicsprinkles.ui.screen.MainScreen
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

class MainActivity : ComponentActivity() {
    class MainViewModel : ViewModel() { /*TODO*/ }
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagicSprinklesTheme {
                MainScreen()
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "Main preview day")
@Composable
private fun DefaultPreview() {
    MagicSprinklesTheme {
        MainScreen()
    }
}


