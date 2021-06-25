package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.maiatoday.magicsprinkles.ui.theme.MagicSprinklesTheme

@ExperimentalAnimationApi
@Composable
fun SizeChangeThingy(modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    val size by animateDpAsState(
        if (isExpanded)
            56.dp
        else
            24.dp
    )
    Column(modifier) {
        Button(onClick = {
            isExpanded = !isExpanded
        }) {
            if (isExpanded) Text("Shrink") else Text("Grow")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .size(size)
                .background(MaterialTheme.colors.secondary)
        )
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true, name = "SizeChangeThingy preview day")
@Composable
private fun DefaultPreview() {
    MagicSprinklesTheme {
        SizeChangeThingy()
    }
}