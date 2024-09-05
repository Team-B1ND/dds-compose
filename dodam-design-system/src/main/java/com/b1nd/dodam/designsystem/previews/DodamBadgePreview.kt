package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamBadge

@Composable
@Preview
fun DodamBadgePreview(

){
    DodamTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamTheme.colors.backgroundNormal)
        ) {
            Row {
                DodamBadge()
                Spacer(modifier = Modifier.width(30.dp))
                DodamBadge(
                    count = "1"
                )
                Spacer(modifier = Modifier.width(30.dp))
                DodamBadge(
                    count = "999+"
                )
            }
        }
    }
}