package com.b1nd.dodam.dds.style

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.b1nd.dodam.dds.foundation.Blue
import com.b1nd.dodam.dds.foundation.Gray200
import com.b1nd.dodam.dds.foundation.Gray300
import com.b1nd.dodam.dds.foundation.Gray400
import com.b1nd.dodam.dds.foundation.Gray600
import com.b1nd.dodam.dds.foundation.Gray700
import com.b1nd.dodam.dds.foundation.Gray750
import com.b1nd.dodam.dds.foundation.Gray850
import com.b1nd.dodam.dds.foundation.Gray900
import com.b1nd.dodam.dds.foundation.White

internal val LightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = White,
    secondary = Gray200,
    tertiary = Gray750,
    surface = Color(0xFFF2F5F8),
    onSurface = Gray900,
    surfaceContainer = White,
    onSurfaceVariant = Gray400,
    outline = Gray300,
    outlineVariant = Gray200,
)

internal val DarkColorScheme = darkColorScheme(
    primary = Blue,
    onPrimary = White,
    secondary = Gray750,
    tertiary = Gray700,
    surface = Gray900,
    onSurface = White,
    surfaceContainer = Gray850,
    onSurfaceVariant = Gray600,
    outline = Gray700,
    outlineVariant = Gray600,
)
