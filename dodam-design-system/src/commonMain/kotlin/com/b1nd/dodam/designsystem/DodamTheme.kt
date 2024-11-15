package com.b1nd.dodam.designsystem

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import com.b1nd.dodam.designsystem.foundation.DodamColors
import com.b1nd.dodam.designsystem.foundation.DodamShapes
import com.b1nd.dodam.designsystem.foundation.DodamTypography
import com.b1nd.dodam.designsystem.foundation.LocalDodamColors
import com.b1nd.dodam.designsystem.foundation.LocalDodamShapes
import com.b1nd.dodam.designsystem.foundation.LocalDodamTypography
import com.b1nd.dodam.designsystem.foundation.darkDodamColors
import com.b1nd.dodam.designsystem.foundation.lightDodamColors

@Composable
fun DodamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val dodamColors = if (darkTheme) darkDodamColors() else lightDodamColors()
    val bounceIndication = rememberBounceIndication()
    CompositionLocalProvider(
        LocalDodamColors provides dodamColors,
        LocalIndication provides bounceIndication,
        LocalDodamShapes provides DodamTheme.shapes,
        LocalDodamTypography provides DodamTheme.typography,
        content = content
    )
}

object DodamTheme {
    val colors: DodamColors
        @Composable
        @ReadOnlyComposable
        get() = LocalDodamColors.current

    val typography: DodamTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalDodamTypography.current

    val shapes: DodamShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalDodamShapes.current
}