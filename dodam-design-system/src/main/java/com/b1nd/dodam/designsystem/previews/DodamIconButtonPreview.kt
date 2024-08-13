package com.b1nd.dodam.designsystem.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamIconButton
import com.b1nd.dodam.designsystem.foundation.DodamIcons

@Composable
@Preview
private fun DodamIconButtonPreview() {
    DodamTheme {
        DodamIconButton(
            onClick = {},
            icon = DodamIcons.Bell,
            enabled = false
        )
    }
}