package com.b1nd.dodam.dds.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role

enum class ButtonState { Pressed, Idle }

@Composable
fun Modifier.bounceClick(
    onClick: () -> Unit,
    enabled: Boolean = true,
    role: Role? = null,
    interactionColor: Color = MaterialTheme.colorScheme.secondary,
    interactionSource: MutableInteractionSource,
    indication: Indication? = null,
) = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }

    val transition = updateTransition(targetState = buttonState, label = "Bounce Effect")

    val scale by transition.animateFloat(label = "scale") {
        if (it == ButtonState.Pressed) 0.9f else 1f
    }
    val color by transition.animateColor(label = "") {
        if (it == ButtonState.Pressed) interactionColor.copy(alpha = 0.8f)
        else interactionColor.copy(alpha = 0f)
    }

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clip(MaterialTheme.shapes.medium)
        .background(color = color)
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

@Composable
fun Modifier.bounceEffect(
    interactionColor: Color = Color.Transparent,
) = composed {
    var buttonState by remember { mutableStateOf(ButtonState.Idle) }

    val transition = updateTransition(targetState = buttonState, label = "Bounce Effect")

    val scale by transition.animateFloat(label = "scale") {
        if (it == ButtonState.Pressed) 0.9f else 1f
    }
    val color by transition.animateColor(label = "") {
        if (it == ButtonState.Pressed) interactionColor.copy(alpha = 0.8f)
        else interactionColor.copy(alpha = 0f)
    }

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clip(MaterialTheme.shapes.medium)
        .background(color = color)
        .pointerInput(buttonState) {
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
