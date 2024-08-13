package com.b1nd.dodam.designsystem.previews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamCheckBox

@Composable
@Preview
private fun DodamCheckBoxPreview() {
    DodamTheme {
        var checked by remember { mutableStateOf(false) }

        DodamCheckBox(
            onClick = { checked = !checked },
            checked = checked,
        )
    }
}