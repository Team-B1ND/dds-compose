package com.b1nd.dodam.dds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.component.button.DodamSmallFilledButton
import com.b1nd.dodam.dds.theme.DodamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           DodamTheme {
               DodamTheme {
                   Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                       DodamSmallFilledButton(
                           onClick = { /*TODO*/ },
                           content = { Text(text = "") }
                       )
                   }
               }
           }
        }
    }
}
