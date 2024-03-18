package com.b1nd.dodam.dds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.component.DodamBadge
import com.b1nd.dodam.dds.component.DodamIconButton
import com.b1nd.dodam.dds.component.DodamTopAppBar
import com.b1nd.dodam.dds.style.HomeIcon
import com.b1nd.dodam.dds.theme.DodamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           DodamTheme {
               DodamIconButton(onClick = { /*TODO*/ }) {
                   HomeIcon()
               }
           }
        }
    }
}
