package net.maiatoday.magicsprinkles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.components.FadeButton
import net.maiatoday.magicsprinkles.ui.components.HideShowThingy
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

class MainActivity : ComponentActivity() {
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

@ExperimentalAnimationApi
@Composable
private fun MainScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            FadeButton(Modifier.align(CenterHorizontally)) {
                Text("Colour fade")
            }
            HideShowThingy(Modifier.align(CenterHorizontally))
        }
    }
}

