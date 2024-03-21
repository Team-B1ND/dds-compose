package com.b1nd.dodam.dds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.component.DodamNavigationBar
import com.b1nd.dodam.dds.component.button.DodamCTAButton
import com.b1nd.dodam.dds.component.button.DodamLargeFilledButton
import com.b1nd.dodam.dds.component.button.DodamMediumFilledButton
import com.b1nd.dodam.dds.component.button.DodamSmallFilledButton
import com.b1nd.dodam.dds.component.rememberDodamNavigationItem
import com.b1nd.dodam.dds.foundation.DodamIcons
import com.b1nd.dodam.dds.theme.DodamTheme
import kotlinx.collections.immutable.persistentListOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           DodamTheme {
               DodamTheme {
                   Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                       DodamSmallFilledButton(
                           onClick = { /*TODO*/ },
                           text = "Filled button",
                       )
                       DodamMediumFilledButton(onClick = { /*TODO*/ }, text = "Filled button")
                       DodamLargeFilledButton(onClick = { /*TODO*/ }, text = "Filled button")
                       DodamCTAButton(onClick = { /*TODO*/ }, text = "Filled button")
                   }
               }
           }
        }
    }
}
