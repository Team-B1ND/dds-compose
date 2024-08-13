package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamButtonDialog
import com.b1nd.dodam.designsystem.component.DodamDialog

@Composable
@Preview
private fun DodamDialogPreview() {
    DodamTheme {
        Column {
            DodamDialog(
                confirmButton = {},
                title = "제목을 입력해주세요",
                body = "본문을 입력해주세요",
            )

            Spacer(modifier = Modifier.height(24.dp))

            DodamButtonDialog(
                confirmButton = {},
                dismissButton = {},
                title = "제목을 입력해주세요",
                body = "본문을 입력해주세요",
            )
        }
    }
}