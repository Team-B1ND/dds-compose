package com.b1nd.dodam.designsystem.foundation

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import com.b1nd.dodam.designsystem.tokens.ShapeTokens

@Immutable
data class DodamShapes(
    val xxSmall: CornerBasedShape = ShapeTokens.XXSmall,
    val xSmall: CornerBasedShape = ShapeTokens.XSmall,
    val small: CornerBasedShape = ShapeTokens.Small,
    val medium: CornerBasedShape = ShapeTokens.Medium,
    val large: CornerBasedShape = ShapeTokens.Large,
    val xLarge: CornerBasedShape = ShapeTokens.XLarge,
    val xxLarge: CornerBasedShape = ShapeTokens.XXLarge,
    val xxxLarge: CornerBasedShape = ShapeTokens.XXXlarge,
)

internal val LocalDodamShapes = staticCompositionLocalOf { DodamShapes() }
