package com.b1nd.dodam.designsystem.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamFilledTextField
import com.b1nd.dodam.designsystem.component.DodamTextField

@Composable
@Preview
private fun DodamTextFieldPreview() {
    val focusManager = LocalFocusManager.current
    var value by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    DodamTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DodamTheme.colors.backgroundNormal)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                    })
                }
        ) {
            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = false,
                enabled = true,
                supportText = "",
                onClickRemoveRequest = {}
            )

            Spacer(modifier = Modifier.height(24.dp))

            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = false,
                enabled = true,
                supportText = "Supporting text",
                onClickRemoveRequest = {}
            )

            Spacer(modifier = Modifier.height(24.dp))

            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = true,
                enabled = true,
                supportText = "",
                onClickRemoveRequest = {}
            )
            Spacer(modifier = Modifier.height(24.dp))
            DodamTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = true,
                enabled = true,
                supportText = "Supporting text",
                onClickRemoveRequest = {}
            )

            DodamFilledTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = false,
                enabled = true,
                supportText = "Supporting text",
                onClickRemoveRequest = {}
            )

            DodamFilledTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = false,
                enabled = false,
                supportText = "Supporting text",
                onClickRemoveRequest = {}
            )

            DodamFilledTextField(
                value = value,
                onValueChange = {
                    value = it
                },
                label = "Label text",
                isError = isError,
                enabled = true,
                supportText = "Supporting text",
                onClickRemoveRequest = {
                    isError = !isError
                }
            )
        }
    }
}