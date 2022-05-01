@file:OptIn(ExperimentalAnimationApi::class)

package net.maiatoday.magicsprinkles.ui.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.component.Counter
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@Composable
fun CounterScreen(count: Int, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface {
            Counter(
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.h3,
                count = count,
                width = 8,
                onClick = onClick
            )
        }
       // Spacer(modifier = Modifier.height(32.dp))
        Surface {
            Counter(
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.h4,
                count = count,
                width = 8,
                onClick = onClick
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "CounterScreen preview day")
@Composable
private fun PreviewCounterScreen() {
    MagicSprinklesTheme {
        CounterScreen(999)
    }
}