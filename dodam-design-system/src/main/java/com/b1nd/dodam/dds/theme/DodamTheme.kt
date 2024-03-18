package com.b1nd.dodam.dds.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.b1nd.dodam.dds.style.DodamDarkColorScheme
import com.b1nd.dodam.dds.style.DodamLightColorScheme
import com.b1nd.dodam.dds.style.DodamShapes
import com.b1nd.dodam.dds.style.DodamTypography

@Composable
fun DodamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
            windowInsetsController.apply {
                hide(WindowInsetsCompat.Type.systemBars())
                systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }

    MaterialTheme(
        colorScheme = if (darkTheme) DodamDarkColorScheme else DodamLightColorScheme,
        typography = DodamTypography,
        shapes = DodamShapes,
        content = content
    )
}
