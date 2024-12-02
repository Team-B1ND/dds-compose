package com.b1nd.dodam.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
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
import com.b1nd.dodam.designsystem.component.DodamAvatarBorder
import com.b1nd.dodam.designsystem.component.DodamCircularProgressIndicator
import com.b1nd.dodam.designsystem.component.DodamLinerProgressIndicator
import com.b1nd.dodam.designsystem.foundation.DodamIcons

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DodamTheme {
                Column {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = DodamIcons.File.value,
                        contentDescription = null
                    )
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = DodamIcons.Photo.value,
                        contentDescription = null
                    )
                }
            }
        }
    }
}
