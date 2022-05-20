package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.coroutines.isActive
import net.maiatoday.magicsprinkles.ui.component.GlitterState.Companion.sizeChanged
import net.maiatoday.magicsprinkles.ui.component.GlitterState.Companion.updateSource
import net.maiatoday.magicsprinkles.ui.theme.SkittlesRainbow

@Composable
fun GlitterBox(rainbow: List<Color> = SkittlesRainbow, fleckCount: Int = 10, visible:Boolean = true) {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    var glitterState by remember {
        mutableStateOf(
            GlitterState(
                speed = 0.5f,
                colors = rainbow,
                glitterShape = GlitterShape.Mixed,
                fleckCount = fleckCount
            )
        )
    }
    var lastFrame by remember { mutableStateOf(-1L) }
    LaunchedEffect(visible) {
        while (visible && isActive) {
            withFrameMillis { newTick ->
                val elapsedMillis = newTick - lastFrame
                val wasFirstFrame = lastFrame < 0
                lastFrame = newTick
                if (wasFirstFrame) return@withFrameMillis
                glitterState.next(elapsedMillis)
            }
        }
    }
    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures {
                offsetX = it.x
                offsetY = it.y
                glitterState = glitterState.updateSource(offsetX, offsetY)
            }
        }
    ) {
        glitterState = glitterState.sizeChanged(this.size)
        if (visible) {
            for (fleck in glitterState.flecks) {
                fleck.draw(drawContext.canvas)
            }
        }
    }

}

enum class GlitterShape {
    Mixed,
    Rectangle,
    Circle
}

data class GlitterState(
    val flecks: List<Fleck> = emptyList(),
    val colors: List<Color>,
    val glitterShape: GlitterShape,
    val size: Size = Size.Zero,
    val speed: Float,
    val fleckCount: Int = 10,
    val sourceX: Float = 0f,
    val sourceY: Float = 0f
) {

    fun next(durationMillis: Long) {
        flecks.forEach {
            it.next(size, durationMillis, speed)
        }
    }

    companion object {
        fun GlitterState.sizeChanged(
            size: Size
        ): GlitterState {
            if (size == this.size) return this
            return copy(
                size = size
            )
        }

        fun GlitterState.updateSource(
            offsetX: Float, offsetY: Float
        ): GlitterState {
            if (offsetX == this.sourceX && offsetY == this.sourceY) return this
            return copy(
                flecks = flecks.filter { it.lifeCount > 0 } + (0..fleckCount).map {
                    Fleck.create(
                        borders = size,
                        colors = colors,
                        glitterShape = glitterShape,
                        offsetX = offsetX,
                        offsetY = offsetY
                    )
                },
                sourceX = offsetX,
                sourceY = offsetY
            )
        }
    }
}

class Fleck(
    vector: Offset,
    private val GlitterColor: Color,
    private val radius: Float,
    private val shape: GlitterShape = GlitterShape.Circle,
    position: Offset
) {
    var lifeCount: Int = 100
    private var position by mutableStateOf(position)
    private var vector by mutableStateOf(vector)
    private val paint: Paint = Paint().apply {
        isAntiAlias = true
        color = GlitterColor
        style = PaintingStyle.Fill
    }

    fun next(
        borders: Size,
        durationMillis: Long,
        speedCoefficient: Float
    ) {
        lifeCount -= 1
        if (lifeCount <= 0) lifeCount = 0
        val speed = vector * speedCoefficient
        val borderTop = 0
        val borderLeft = 0
        val borderBottom = borders.height
        val borderRight = borders.width

        position = Offset(
            x = position.x + (speed.x / 1000f * durationMillis),
            y = position.y + (speed.y / 1000f * durationMillis),
        )
        val vx = if (position.x < borderLeft || position.x > borderRight) -vector.x else vector.x
        val vy = if (position.y < borderTop || position.y > borderBottom) -vector.y else vector.y

        if (vx != vector.x || vy != vector.y) {
            vector = Offset(vx, vy)
        }
    }

    fun draw(canvas: Canvas) {
        if (lifeCount > 0) {
            when (shape) {
                GlitterShape.Circle -> {
                    canvas.drawCircle(
                        radius = radius,
                        center = position,
                        paint = paint
                    )
                }
                GlitterShape.Rectangle -> {
                    val rect =
                        Rect(position.x, position.y, position.x + radius, position.y + radius)
                    canvas.drawRect(
                        rect = rect,
                        paint = paint
                    )
                }
            }
        }
    }

    companion object {

        fun create(
            borders: Size,
            colors: List<Color>,
            glitterShape: GlitterShape,
            offsetX: Float = 0f,
            offsetY: Float = 0f
        ): Fleck {
            val shape = if (glitterShape == GlitterShape.Mixed) {
                if ((0..1).random() == 0) GlitterShape.Circle else GlitterShape.Rectangle
            } else glitterShape
            return Fleck(
                position = Offset(
                    offsetX,
                    offsetY
                ),
                vector = Offset(
                    // First, randomize direction. Second, randomize amplitude of speed vector.
                    listOf(
                        -1f,
                        1f
                    ).random() * ((borders.width / 100f).toInt()..(borders.width / 10f).toInt()).random()
                        .toFloat(),
                    listOf(
                        -1f,
                        1f
                    ).random() * ((borders.height / 100f).toInt()..(borders.height / 10f).toInt()).random()
                        .toFloat()
                ),
                GlitterColor = colors.random(),
                radius = (5..25).random().toFloat(),
                shape = shape
            )
        }
    }
}