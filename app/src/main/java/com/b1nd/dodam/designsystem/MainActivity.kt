package com.b1nd.dodam.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import com.b1nd.dodam.designsystem.component.AvatarSize
import com.b1nd.dodam.designsystem.component.DodamAvatar

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DodamTheme {
                Column {
                    DodamAvatar(
                        model = "https://dodam.kr.object.ncloudstorage.com/dodam/6634113f-951b-430c-81c9-957de0e8abddalimo.png",
                        avatarSize = AvatarSize.Large
                    )
                }
            }
        }
    }
}
