package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.ActionIcon
import com.b1nd.dodam.designsystem.component.DodamDefaultTopAppBar
import com.b1nd.dodam.designsystem.component.DodamTopAppBar
import com.b1nd.dodam.designsystem.component.TopAppBarType
import com.b1nd.dodam.designsystem.foundation.DodamIcons
import kotlinx.collections.immutable.persistentListOf

@Composable
@Preview
private fun DodamTopAppBarPreview() {
    DodamTheme {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            DodamDefaultTopAppBar(
                title = "Title",
                actionIcons = persistentListOf(
                    ActionIcon(
                        icon = DodamIcons.Plus,
                        onClick = {},
                    ),
                    ActionIcon(
                        icon = DodamIcons.Bell,
                        onClick = {},
                    ),
                )
            )
            DodamTopAppBar(
                title = "Title",
                onBackClick = {},
                actionIcons = persistentListOf(
                    ActionIcon(
                        icon = DodamIcons.Plus,
                        onClick = {},
                    ),
                    ActionIcon(
                        icon = DodamIcons.Bell,
                        onClick = {},
                    ),
                )
            )
            DodamTopAppBar(
                title = "Title",
                onBackClick = {},
                type = TopAppBarType.Medium,
                actionIcons = persistentListOf(
                    ActionIcon(
                        icon = DodamIcons.Plus,
                        onClick = {},
                    ),
                    ActionIcon(
                        icon = DodamIcons.Bell,
                        onClick = {},
                    ),
                )
            )
            DodamTopAppBar(
                title = "Title",
                onBackClick = {},
                type = TopAppBarType.Large,
                actionIcons = persistentListOf(
                    ActionIcon(
                        icon = DodamIcons.Plus,
                        onClick = {},
                    ),
                    ActionIcon(
                        icon = DodamIcons.Bell,
                        onClick = {},
                    ),
                )
            )
        }
    }
}