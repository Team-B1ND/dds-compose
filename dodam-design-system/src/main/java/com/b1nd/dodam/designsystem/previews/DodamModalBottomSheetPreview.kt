package com.b1nd.dodam.designsystem.previews

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamModalBottomSheet

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun DodamModalBottomSheetPreview() {
    DodamTheme {
        DodamModalBottomSheet(
            title = {
                Text(text = "테스트")
            },
            content = {
                Text(text = "테스트")
                Text(text = "테스트")
                Text(text = "테스트")
            },
            onDismissRequest = {}
        )
    }
}