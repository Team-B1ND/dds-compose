package com.b1nd.dodam.designsystem.previews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamTab
import com.b1nd.dodam.designsystem.component.DodamTabRow
import kotlinx.collections.immutable.toImmutableList

@Composable
@Preview
private fun DodamTabRowPreview() {
    DodamTheme {
        var selectedTabIndex by remember { mutableIntStateOf(0) }

        val tabs = listOf(
            DodamTab(selected = selectedTabIndex == 0, label = "Tab1") { selectedTabIndex = 0 },
            DodamTab(selected = selectedTabIndex == 1, label = "Tab2") { selectedTabIndex = 1 },
            DodamTab(selected =  selectedTabIndex ==2, label = "Tab3", enabled = false) { selectedTabIndex = 2 },
        ).toImmutableList()

        DodamTabRow(tabs = tabs)
    }
}
