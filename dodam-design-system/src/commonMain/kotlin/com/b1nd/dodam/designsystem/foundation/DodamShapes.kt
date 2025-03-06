package com.b1nd.dodam.designsystem.foundation

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.b1nd.dodam.designsystem.tokens.ShapeTokens

@Immutable
data class DodamShapes(
    val extraSmall: CornerBasedShape = ShapeTokens.ExtraSmall,
    val small: CornerBasedShape = ShapeTokens.Small,
    val medium: CornerBasedShape = ShapeTokens.Medium,
    val large: CornerBasedShape = ShapeTokens.Large,
    val extraLarge: CornerBasedShape = ShapeTokens.ExtraLarge,
    val extraLargeTopRound: CornerBasedShape = ShapeTokens.ExtraLargeTopRound
)

internal val LocalDodamShapes = staticCompositionLocalOf { DodamShapes() }
