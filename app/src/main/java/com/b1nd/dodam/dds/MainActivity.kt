package com.b1nd.dodam.dds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.b1nd.dodam.dds.component.DodamNavigationBar
import com.b1nd.dodam.dds.component.button.DodamCTAButton
import com.b1nd.dodam.dds.component.button.DodamLargeFilledButton
import com.b1nd.dodam.dds.component.button.DodamTextButton
import com.b1nd.dodam.dds.component.rememberDodamNavigationItem
import com.b1nd.dodam.dds.foundation.DodamIcons
import com.b1nd.dodam.dds.theme.DodamTheme
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list = persistentListOf(
                rememberDodamNavigationItem("home", DodamIcons.Home),
                rememberDodamNavigationItem("meal", DodamIcons.ForkAndKnife),
                rememberDodamNavigationItem("out", DodamIcons.DoorOpen),
                rememberDodamNavigationItem("nightstudy", DodamIcons.MoonPlus),
                rememberDodamNavigationItem("menu", DodamIcons.Menu),
            )

            DodamTheme {
                Box(Modifier.fillMaxSize()) {
                    DodamNavigationBar(navigationItems = list) {

                    }
                }
            }
        }
    }
}
