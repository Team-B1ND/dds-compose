package com.b1nd.dodam.dds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.component.DodamBadge
import com.b1nd.dodam.dds.component.DodamIconButton
import com.b1nd.dodam.dds.component.DodamNavigationBar
import com.b1nd.dodam.dds.component.DodamNavigationItem
import com.b1nd.dodam.dds.component.DodamTopAppBar
import com.b1nd.dodam.dds.component.rememberDodamNavigationItem
import com.b1nd.dodam.dds.foundation.DodamIcons
import com.b1nd.dodam.dds.style.DoorOpenIcon
import com.b1nd.dodam.dds.style.ForkAndKnifeIcon
import com.b1nd.dodam.dds.style.HomeIcon
import com.b1nd.dodam.dds.style.MenuIcon
import com.b1nd.dodam.dds.style.MoonPlusIcon
import com.b1nd.dodam.dds.theme.DodamTheme
import kotlinx.collections.immutable.persistentListOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           DodamTheme {
               DodamNavigationBar(
                   navigationItems = persistentListOf(
                       rememberDodamNavigationItem("home", DodamIcons.Home),
                       rememberDodamNavigationItem("meal", DodamIcons.ForkAndKnife),
                       rememberDodamNavigationItem("out", DodamIcons.DoorOpen),
                       rememberDodamNavigationItem("nightstudy", DodamIcons.MoonPlus),
                       rememberDodamNavigationItem("menu", DodamIcons.Menu),
                   ),
                   onClickItem = {

                   },
               )
           }
        }
    }
}
