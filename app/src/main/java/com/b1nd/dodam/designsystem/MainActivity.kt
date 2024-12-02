package com.b1nd.dodam.designsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.component.AvatarSize
import com.b1nd.dodam.designsystem.component.DodamAvatar
import com.b1nd.dodam.designsystem.component.DodamAvatarBorder
import com.b1nd.dodam.designsystem.component.DodamCircularProgressIndicator
import com.b1nd.dodam.designsystem.component.DodamFilledTextField
import com.b1nd.dodam.designsystem.component.DodamLinerProgressIndicator
import com.b1nd.dodam.designsystem.component.DodamTextField
import com.b1nd.dodam.designsystem.foundation.DodamIcons

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var value by remember { mutableStateOf("testValueqwewqjeoqw\nqwe\n\n\n\n\nqeqwe") }
            var textFieldValue by remember { mutableStateOf(TextFieldValue("qwe\nqwe\nqwe\nqwe\nqwe\nqwe\nqwe\nqwe")) }
            DodamTheme {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DodamTextField(
                        modifier = Modifier.weight(1f),
                        value = value,
                        onValueChange = {
                            value = it
                        }
                    )

//                    DodamFilledTextField(
//                        value = value,
//                        onValueChange = {
//                            value = it
//                        }
//                    )

                    DodamTextField(
                        modifier = Modifier.weight(1f),
                        value = textFieldValue,
                        onValueChange = {
                            textFieldValue = it
                        },
                        isShowDivider = false
                    )
//                    DodamFilledTextField(
//                        value = textFieldValue,
//                        onValueChange = {
//                            textFieldValue = it
//                        }
//                    )
                }
            }
        }
    }
}
