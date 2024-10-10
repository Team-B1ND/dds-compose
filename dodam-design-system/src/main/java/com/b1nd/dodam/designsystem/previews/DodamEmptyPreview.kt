package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamEmpty

@Composable
@Preview
fun DodamEmptyPreview(

){
    DodamTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamTheme.colors.backgroundNormal)
        ) {
            DodamEmpty(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = { },
                title = "외출/외박 승인 명단을 불러올 수 없어요",
                buttonText = "다시 불러오기"
            )
            DodamEmpty(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = { },
                title = "외출/외박 승인 명단을 불러올 수 없어요",
                buttonText = "다시 불러오기",
                border = BorderStroke(
                    width = 1.dp,
                    color = DodamTheme.colors.lineAlternative
                )
            )
        }
    }
}