package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import kotlin.math.roundToInt

@Composable
fun CursorVisible(content: @Composable () -> Unit) {
    val boxSize = 100.dp
    val boxPx = with(LocalDensity.current) { boxSize.toPx() }
    var offset by remember { mutableStateOf(Offset(0f, 0f)) }
    var visible by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures {
                offset = it - Offset(boxPx/2, boxPx/2)
                visible = !visible
            }
        }
    ) {
        if (visible) {
            Box(
                Modifier
                    .offset { offset.round() }
                    .size(boxSize)
                    .pointerInput(Unit) {
                        detectDragGestures { change, dragAmount ->
                            change.consumeAllChanges()
                            offset += dragAmount
                        }
                    }
            ) {
                content()
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    CursorVisible {
        Box(
            Modifier
                .size(80.dp)
                .background(Color.Magenta))
    }
}