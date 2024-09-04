package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.AvatarSize
import com.b1nd.dodam.designsystem.component.DodamAvatar

@Composable
@Preview
fun DodamAvatarPreview(

){
    DodamTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamTheme.colors.backgroundNormal)
        ) {
            DodamAvatar(
                avatarSize = AvatarSize.ExtraSmall
            )
            DodamAvatar(
                avatarSize = AvatarSize.Small
            )
            DodamAvatar(
                avatarSize = AvatarSize.Medium
            )
            DodamAvatar(
                avatarSize = AvatarSize.Large
            )
            DodamAvatar(
                avatarSize = AvatarSize.ExtraLarge
            )
            DodamAvatar(
                avatarSize = AvatarSize.XXL
            )
        }
    }
}