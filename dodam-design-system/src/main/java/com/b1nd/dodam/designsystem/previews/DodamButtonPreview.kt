package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.ButtonRole
import com.b1nd.dodam.designsystem.component.ButtonSize
import com.b1nd.dodam.designsystem.component.DodamButton

@Composable
@Preview
private fun DodamButtonPreview() {
    DodamTheme {
        var loading by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Primary,
                    buttonSize = ButtonSize.Large,

                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Secondary,
                    buttonSize = ButtonSize.Large,
                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Assistive,
                    buttonSize = ButtonSize.Large,
                    text = "Button",
                    loading = loading
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Primary,
                    buttonSize = ButtonSize.Large,
                    enabled = false,
                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Secondary,
                    buttonSize = ButtonSize.Large,
                    enabled = false,
                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Assistive,
                    buttonSize = ButtonSize.Large,
                    enabled = false,
                    text = "Button",
                    loading = loading
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Primary,
                    buttonSize = ButtonSize.Medium,
                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Secondary,
                    buttonSize = ButtonSize.Medium,
                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Assistive,
                    buttonSize = ButtonSize.Medium,
                    text = "Button",
                    loading = loading
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Primary,
                    buttonSize = ButtonSize.Small,
                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Secondary,
                    buttonSize = ButtonSize.Small,
                    text = "Button",
                    loading = loading
                )

                DodamButton(
                    onClick = { loading = true },
                    buttonRole = ButtonRole.Assistive,
                    buttonSize = ButtonSize.Small,
                    text = "Button",
                    loading = loading
                )
            }
            DodamButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { loading = true },
                buttonRole = ButtonRole.Assistive,
                buttonSize = ButtonSize.Large,
                text = "Button",
                loading = loading,
                enabled = !loading
            )
            DodamButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { loading = true },
                buttonRole = ButtonRole.Assistive,
                buttonSize = ButtonSize.Large,
                text = "Button",
                loading = loading,
                enabled = loading
            )
            DodamButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { loading = true },
                buttonRole = ButtonRole.Assistive,
                buttonSize = ButtonSize.Large,
                text = "Button",
                loading = loading,
                enabled = loading
            )
        }
    }
}
