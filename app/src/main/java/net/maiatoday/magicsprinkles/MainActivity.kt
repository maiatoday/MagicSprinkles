package net.maiatoday.magicsprinkles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.maiatoday.magicsprinkles.ui.components.FadeButton
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagicSprinklesTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier)
}

@Preview(showBackground = true, name = "Main preview day")
@Composable
fun DefaultPreview() {
    MagicSprinklesTheme {
        MainScreen()
    }
}

@Composable
private fun MainScreen() {
    Surface(color = MaterialTheme.colors.background) {
        FadeButton(Modifier.fillMaxWidth()) {
            Greeting("Android")
        }
    }
}

