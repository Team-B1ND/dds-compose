package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamTag
import com.b1nd.dodam.designsystem.component.TagType

@Composable
@Preview
private fun DodamTagPreview(

) {

    DodamTheme(
        darkTheme = true
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamTheme.colors.backgroundNormal)
        ) {
            DodamTag(
                text = "아침",
                tagType = TagType.Primary
            )
            DodamTag(
                text = "아침",
                tagType = TagType.Secondary
            )
            DodamTag(
                text = "아침",
                tagType = TagType.Negative
            )
        }
    }
}