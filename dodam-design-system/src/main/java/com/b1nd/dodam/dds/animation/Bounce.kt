package com.b1nd.dodam.dds.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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

@Composable
fun Modifier.bounceClick(
    onClick: () -> Unit,
    enabled: Boolean = true,
    role: Role? = null,
    interactionColor: Color = MaterialTheme.colorScheme.secondary,
    interactionSource: MutableInteractionSource,
    indication: Indication? = null,
) = composed {
    val pressed by interactionSource.collectIsPressedAsState()

    val transition = updateTransition(targetState = pressed, label = "Bounce Effect")

    val scale by transition.animateFloat(label = "scale") {
        if (it) 0.95f else 1f
    }
    val color by transition.animateColor(label = "") {
        if (interactionColor != Color.Transparent) {
            if (it) interactionColor.copy(alpha = 0.8f)
            else interactionColor.copy(alpha = 0f)
        } else {
            Color.Transparent
        }
    }

    this
        .background(color = color)
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clip(MaterialTheme.shapes.medium)
        .clickable(
            enabled = enabled,
            role = role,
            interactionSource = interactionSource,
            indication = indication,
            onClick = onClick,
        )
}

@Composable
fun Modifier.bounceEffect(
    interactionColor: Color = Color.Transparent,
) = composed {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val transition = updateTransition(targetState = pressed, label = "Bounce Effect")

    val scale by transition.animateFloat(label = "scale") {
        if (it) 0.95f else 1f
    }
    val color by transition.animateColor(label = "") {
        if (interactionColor != Color.Transparent) {
            if (it) interactionColor.copy(alpha = 0.8f)
            else interactionColor.copy(alpha = 0f)
        } else {
            Color.Transparent
        }
    }

    this
        .graphicsLayer {
            scaleX = scale
            scaleY = scale
        }
        .clip(MaterialTheme.shapes.medium)
        .background(color = color)
        .indication(interactionSource, indication = null)
}
