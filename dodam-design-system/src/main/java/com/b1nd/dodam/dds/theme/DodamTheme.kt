package com.b1nd.dodam.dds.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.b1nd.dodam.dds.style.DodamDarkColorScheme
import com.b1nd.dodam.dds.style.DodamLightColorScheme
import com.b1nd.dodam.dds.style.DodamShapes
import com.b1nd.dodam.dds.style.DodamTypography

@Composable
fun DodamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DodamDarkColorScheme else DodamLightColorScheme,
        typography = DodamTypography,
        shapes = DodamShapes,
        content = content
    )
}
