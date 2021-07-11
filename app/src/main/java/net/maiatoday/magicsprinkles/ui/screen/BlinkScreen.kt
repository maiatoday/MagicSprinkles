package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.R
import net.maiatoday.magicsprinkles.ui.component.BlinkTag
import net.maiatoday.magicsprinkles.ui.component.BlinkText
import net.maiatoday.magicsprinkles.ui.component.LocalContentBlinkTag
import net.maiatoday.magicsprinkles.ui.component.ThemedBlinkText
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme
import net.maiatoday.magicsprinkles.ui.theme.PastelRainbowRed
import net.maiatoday.magicsprinkles.ui.theme.RainbowBlue
import net.maiatoday.magicsprinkles.ui.theme.RainbowOrange
import net.maiatoday.magicsprinkles.ui.theme.RainbowRed

@ExperimentalAnimationApi
@Composable
fun BlinkScreen() {
    Surface(color = MaterialTheme.colors.background) {
        var text by rememberSaveable { mutableStateOf("<blink>") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val spacer = Modifier.height(16.dp)
            Text(
                "<blink>",
                modifier = Modifier.padding(8.dp)
            )
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Blink message") }
            )
            ThemedBlinkText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = spacer)
            BlinkText(
                text = text,
                color = Color.Green,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color.Black),
                style = MaterialTheme.typography.h4,
                durationMillis = 2000
            )
            Spacer(modifier = spacer)
            LocalContentBlinkTag {
                Column {
                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                        Text(text = "blinky")
                    }
                    Row {
                        Text(text = "pinky")
                        Icon(
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                    }
                    Row {
                        Text(text = "inky")
                        Icon(
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                    }

                    Row {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                        Text(text = "clyde")
                    }
                }
            }
            Spacer(modifier = spacer)
            BlinkTag {
                Column {
                    Row {
                        Icon(
                            tint = RainbowRed,
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                        Text(
                            text = "blinky",
                            color = RainbowRed,
                            modifier = it
                                .padding(8.dp)
                        )
                    }
                    Row {
                        Text(
                            text = "pinky",
                            color = PastelRainbowRed,
                            modifier = it
                                .padding(8.dp)
                        )
                        Icon(
                            tint = PastelRainbowRed,
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                    }
                    Row {
                        Text(
                            text = "inky",
                            color = RainbowBlue,
                            modifier = it
                                .padding(8.dp)
                        )
                        Icon(
                            tint = RainbowBlue,
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                    }

                    Row {
                        Icon(
                            tint = RainbowOrange,
                            painter = painterResource(id = R.drawable.ic_android_black_24dp),
                            contentDescription = null // decorative element
                        )
                        Text(
                            text = "clyde",
                            color = RainbowOrange,
                            modifier = it
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "BlinkScreen preview day")
@Composable
private fun PreviewBlinkScreen() {
    MagicSprinklesTheme {
        BlinkScreen()
    }
}