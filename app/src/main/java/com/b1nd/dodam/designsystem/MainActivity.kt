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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.component.AvatarSize
import com.b1nd.dodam.designsystem.component.DodamAvatar
import com.b1nd.dodam.designsystem.component.DodamCircularProgressIndicator
import com.b1nd.dodam.designsystem.component.DodamLinerProgressIndicator

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
                        progress = 0f
                    )
                    DodamLinerProgressIndicator(
                        modifier = Modifier.fillMaxWidth(),
                        progress = 0f
                    )
                }
            }
        }
    }
}
