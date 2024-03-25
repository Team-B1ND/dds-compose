package com.b1nd.dodam.dds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.b1nd.dodam.dds.component.DodamDialog
import com.b1nd.dodam.dds.component.button.DodamCTAButton
import com.b1nd.dodam.dds.component.button.DodamLargeFilledButton
import com.b1nd.dodam.dds.component.button.DodamTextButton
import com.b1nd.dodam.dds.theme.DodamTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var showDialog by remember { mutableStateOf(false) }

            DodamTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    if (showDialog) {
                        DodamDialog(
                            modifier = Modifier.align(Alignment.Center),
                            onDismissRequest = { showDialog = false },
                            title = { Text(text = "제목을 입력해주세요") },
                            text = { Text(text = "본문을 입력해주세요") },
                            confirmButton = {
                                DodamLargeFilledButton(
                                    modifier = Modifier.weight(1f),
                                    onClick = { showDialog = false }) {
                                    Text(text = "확인")
                                }
                            },
                            dismissButton = {
                                DodamLargeFilledButton(
                                    modifier = Modifier.weight(1f),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                    ),
                                    onClick = { showDialog = false }) {
                                    Text(text = "취소")
                                }
                            }
                        )
                    }

                    DodamCTAButton(onClick = { showDialog = true }) {
                        Text(text = "다이얼로그")
                    }
                }
            }
        }
    }
}
