package com.b1nd.dodam.designsystem.component

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun DodamLoadingDots(
    count: Int = 3,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(LoadingDotsDefault.SpacingBetweenDots)) {
        repeat(count) {
            val color = LoadingDotsDefault.DotColor
            val animColor = remember { Animatable(color) }

            LaunchedEffect(Unit) {
                delay(LoadingDotsDefault.COLOR_ANIMATION_DELAY * (it + 1))
                launch {
                    animColor.animateTo(
                        color.copy(alpha = 0.1f),
                        animationSpec = infiniteRepeatable(
                            animation = tween(
                                durationMillis = LoadingDotsDefault.COLOR_ANIMATION_DURATION,
                                easing = LinearEasing,
                            ),
                            repeatMode = RepeatMode.Reverse,
                        ),
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(LoadingDotsDefault.DotSize)
                    .background(animColor.value, CircleShape),
            )
        }
    }
}

private object LoadingDotsDefault {
    val DotSize = 8.dp
    val SpacingBetweenDots = 8.dp
    val DotColor @Composable get() = DodamTheme.colors.labelAlternative.copy(alpha = 0.5f)

    const val COLOR_ANIMATION_DURATION = 500
    const val COLOR_ANIMATION_DELAY = 200L
}
