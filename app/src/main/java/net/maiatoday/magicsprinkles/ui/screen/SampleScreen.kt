package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.component.ColourThingy
import net.maiatoday.magicsprinkles.ui.component.CrossFadeThingy
import net.maiatoday.magicsprinkles.ui.component.HideShowThingy
import net.maiatoday.magicsprinkles.ui.component.SizeChangeThingy
import net.maiatoday.magicsprinkles.ui.components.TransitionThingy
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun SampleScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ColourThingy(Modifier.align(Alignment.CenterHorizontally))
            CrossFadeThingy(Modifier.align(Alignment.CenterHorizontally))
            HideShowThingy(
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            )
            SizeChangeThingy(Modifier.align(Alignment.CenterHorizontally))
            TransitionThingy(Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "SampleScreen preview day")
@Composable
private fun PreviewSampleScreen() {
    MagicSprinklesTheme {
        SampleScreen()
    }
}