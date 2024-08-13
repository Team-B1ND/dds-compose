package com.b1nd.dodam.designsystem.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamLoadingDots

@Composable
@Preview
private fun DodamLoadingDotsPreview() {
    DodamTheme {
        DodamLoadingDots()
    }
}