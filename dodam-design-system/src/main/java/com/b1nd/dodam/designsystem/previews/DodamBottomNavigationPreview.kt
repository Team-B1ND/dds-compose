package com.b1nd.dodam.designsystem.previews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamNavigationBar
import com.b1nd.dodam.designsystem.component.DodamNavigationBarItem
import com.b1nd.dodam.designsystem.component.NavigationBarType
import com.b1nd.dodam.designsystem.foundation.DodamIcons
import kotlinx.collections.immutable.toImmutableList

@Composable
@Preview
private fun DodamBottomNavigationPreview() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val icons = listOf(
        DodamIcons.Home,
        DodamIcons.ForkAndKnife,
        DodamIcons.DoorOpen,
        DodamIcons.MoonPlus,
        DodamIcons.Menu
    )
    val items = List(5) { index ->
        DodamNavigationBarItem(
            selected = selectedIndex == index,
            icon = icons[index],
            onClick = { selectedIndex = index }
        )
    }.toImmutableList()

    DodamTheme {
        DodamNavigationBar(
            items = items,
            type = NavigationBarType.Border
        )
    }
}
