package com.b1nd.dodam.dds.style

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.b1nd.dodam.dds.foundation.DodamColor


internal val DodamLightColorScheme = lightColorScheme(
    primary = DodamColor.Blue,
    onPrimary = DodamColor.White,
    secondary = DodamColor.Gray200,
    secondaryContainer = DodamColor.Gray200,
    onSecondaryContainer = DodamColor.Gray750,
    tertiary = DodamColor.Gray650,
    error = DodamColor.Red,
    onError = DodamColor.White,
    surface = Color(0xFFF2F5F8),
    onSurface = DodamColor.Gray900,
    surfaceContainer = DodamColor.White,
    surfaceContainerHigh = DodamColor.White,
    surfaceContainerLow = DodamColor.White,
    onSurfaceVariant = DodamColor.Gray400,
    outline = DodamColor.Gray300,
    outlineVariant = DodamColor.Gray200,
)

internal val DodamDarkColorScheme = darkColorScheme(
    primary = DodamColor.Blue,
    onPrimary = DodamColor.White,
    secondary = DodamColor.Gray750,
    secondaryContainer = DodamColor.Gray750,
    onSecondaryContainer = DodamColor.Gray350,
    tertiary = DodamColor.Gray350,
    error = DodamColor.Red,
    onError = DodamColor.White,
    surface = DodamColor.Gray900,
    onSurface = DodamColor.White,
    surfaceContainer = DodamColor.Gray850,
    surfaceContainerLow = DodamColor.Gray650,
    surfaceContainerHigh = DodamColor.Gray850,
    onSurfaceVariant = DodamColor.Gray600,
    outline = DodamColor.Gray700,
    outlineVariant = DodamColor.Gray600,
)
