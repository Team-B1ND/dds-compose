package com.b1nd.dodam.designsystem.animation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme

internal class BounceIndication(
    private val scale: Float,
    private val radius: CornerBasedShape
) : Indication {

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        val transition = updateTransition(
            targetState = interactionSource.collectIsPressedAsState().value,
            label = "BounceIndicationTransition"
        )
        val scale by transition.animateFloat(
            transitionSpec = { spring() },
            label = "BounceIndicationScale"
        ) {
            if (it) scale else 1f
        }
        val color by transition.animateColor(
            transitionSpec = { spring() },
            label = "BounceIndicationColor"
        ) {
            if (it) {
                BounceIndicationDefaults.DefaultColor.copy(alpha = 0.24f)
            } else {
                BounceIndicationDefaults.DefaultColor.copy(alpha = 0f)
            }
        }

        return BounceIndicationInstance(scale, radius, color)
    }

    inner class BounceIndicationInstance(
        private val scale: Float,
        private val radius: CornerBasedShape,
        private val color: Color
    ) : IndicationInstance {

        override fun ContentDrawScope.drawIndication() {

            scale(scale) {
                this@drawIndication.drawContent()
                drawRoundRect(
                    color = color,
                    cornerRadius = CornerRadius(
                        radius.topStart.toPx(size, Density(density)),
                        radius.bottomEnd.toPx(size, Density(density))
                    )
                )
            }
        }
    }
}

@Composable
fun rememberBounceIndication(
    radius: CornerBasedShape = BounceIndicationDefaults.DefaultRadius,
    scale: Float = BounceIndicationDefaults.DEFAULT_SCALE,
): Indication {
    return remember { BounceIndication(scale, radius) }
}

internal object BounceIndicationDefaults {
    const val DEFAULT_SCALE = 0.95f

    val DefaultRadius = RoundedCornerShape(4.dp)
    val DefaultColor @Composable get() = DodamTheme.colors.staticBlack
}