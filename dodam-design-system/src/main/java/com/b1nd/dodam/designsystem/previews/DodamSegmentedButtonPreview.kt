package com.b1nd.dodam.designsystem.previews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamSegment
import com.b1nd.dodam.designsystem.component.DodamSegmentedButton
import kotlinx.collections.immutable.toImmutableList

@Composable
@Preview
private fun DodamSegmentedButtonPreview() {
    DodamTheme {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val texts = listOf(
            "First",
            "Second",
            "Third",
            "Fourth",
            "Fifth",
        )
        val items = List(5) { index ->
            DodamSegment(
                selected = selectedIndex == index,
                text = texts[index],
                onClick = { selectedIndex = index },
            )
        }.toImmutableList()

        DodamSegmentedButton(
            segments = items
        )
    }
}