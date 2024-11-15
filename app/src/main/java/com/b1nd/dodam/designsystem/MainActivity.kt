package com.b1nd.dodam.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.component.AvatarSize
import com.b1nd.dodam.designsystem.component.DodamAvatar
import com.b1nd.dodam.designsystem.component.DodamCircularProgressIndicator
import com.b1nd.dodam.designsystem.component.DodamLinerProgressIndicator
import com.b1nd.dodam.designsystem.foundation.DodamIcons

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DodamTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    DodamCircularProgressIndicator(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .size(40.dp),
                        progress = 0.5f
                    )
                    DodamLinerProgressIndicator(
                        modifier = Modifier.fillMaxWidth(),
                        progress = 0f
                    )
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = DodamIcons.Person.value,
                        contentDescription = null
                    )
                    Icon(
                        modifier = Modifier.size(50.dp),
                        imageVector = DodamIcons.Bus.value,
                        contentDescription = null
                    )
                    DodamAvatar(
                        model = "https://dodam.kr.object.ncloudstorage.com/dodam/6634113f-951b-430c-81c9-957de0e8abddalimo.png",
                        avatarSize = AvatarSize.Large
                    )
                }
            }
        }
    }
}
