package com.b1nd.dodam.dds.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role
import com.b1nd.dodam.dds.foundation.DodamShape

enum class ButtonState { Pressed, Idle }

fun Modifier.bounceClick(
    onClick: () -> Unit,
    enabled: Boolean = true,
    role: Role? = null,
    interactionSource: MutableInteractionSource,
    indication: Indication? = null,
) = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }
    val scale by animateFloatAsState(
        if (buttonState == ButtonState.Pressed) 0.9f else 1f,
        label = "",
    )
    val color by animateColorAsState(
        targetValue = if (buttonState == ButtonState.Pressed) {
            MaterialTheme.colorScheme.secondary.copy(
                alpha = 0.8f,
            )
        } else {
            MaterialTheme.colorScheme.secondary.copy(
                alpha = 0f,
            )
        },
        label = "",
    )

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clip(DodamShape.Large)
        .background(color = color,)
        .clickable(
            enabled = enabled,
            role = role,
            interactionSource = interactionSource,
            indication = indication,
            onClick = onClick,
        )
        .pointerInput(buttonState) {
            if (enabled) {
                awaitPointerEventScope {
                    buttonState = if (buttonState == ButtonState.Pressed) {
                        waitForUpOrCancellation()
                        ButtonState.Idle
                    } else {
                        awaitFirstDown(false)
                        ButtonState.Pressed
                    }
                }
            }
        }
}

