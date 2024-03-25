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
import androidx.compose.runtime.LaunchedEffect
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
import kotlinx.coroutines.delay

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var enabled by remember { mutableStateOf(false) }
            
            LaunchedEffect(Unit) {
                delay(3000)
                enabled = true
            }

            DodamTheme {
                DodamCTAButton(
                    onClick = { /*TODO*/ },
                    enabled = enabled
                ) {
                    Text(text = "TEST")
                }
            }
        }
    }
}
