package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.maiatoday.magicsprinkles.MainViewModel
import net.maiatoday.magicsprinkles.ui.component.ColourThingy
import net.maiatoday.magicsprinkles.ui.component.HideShowThingy
import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalAnimationApi
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ColourThingy(Modifier.align(Alignment.CenterHorizontally))
            HideShowThingy(Modifier.align(Alignment.CenterHorizontally))
        }
    }
}