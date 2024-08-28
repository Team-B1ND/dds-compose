package com.b1nd.dodam.designsystem.internal

import androidx.compose.ui.Modifier

internal inline fun Modifier.`if`(enabled: Boolean, modifier: Modifier.() -> Modifier) =
    if (enabled) modifier() else this