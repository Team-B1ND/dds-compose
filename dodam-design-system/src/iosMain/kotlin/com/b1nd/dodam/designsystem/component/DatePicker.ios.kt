package com.b1nd.dodam.designsystem.component

import androidx.compose.material3.CalendarLocale
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable


internal actual fun formatWithSkeleton(
    utcTimeMillis: Long,
    skeleton: String,
    locale: com.b1nd.dodam.designsystem.component.CalendarLocale,
    cache: MutableMap<String, Any>,
): String {
    TODO("Not yet implemented")
}

@ReadOnlyComposable
@Composable
internal actual fun defaultLocale(): com.b1nd.dodam.designsystem.component.CalendarLocale {
    TODO("Not yet implemented")
}

internal actual fun createCalendarModel(locale: com.b1nd.dodam.designsystem.component.CalendarLocale): CalendarModel {
    TODO("Not yet implemented")
}