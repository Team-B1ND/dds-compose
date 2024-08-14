package com.b1nd.dodam.designsystem.previews

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.ComposeUIViewController
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamDatePicker
import com.b1nd.dodam.designsystem.component.DodamDatePickerBottomSheet
import com.b1nd.dodam.designsystem.component.DodamDatePickerDialog
import com.b1nd.dodam.designsystem.component.rememberDodamDatePickerState
import kotlinx.coroutines.launch

fun DodamDatePickerController() = ComposeUIViewController { DodamDatePickerPreview() }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DodamDatePickerPreview() {
    val datePickerState = rememberDodamDatePickerState()
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var isShowDialog by remember { mutableStateOf(true) }
    var isShowBottomSheet by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = true) {
        sheetState.show()
    }
    DodamTheme {
        if (isShowDialog) {
            DodamDatePickerDialog(
                state = datePickerState,
                onDismissRequest = {
                    isShowDialog = false
                },
                onClickDate = { date, isValid ->
                    datePickerState.selectedDate = date
                },
                onClickSuccess = {
                    isShowDialog = false
                }
            )
        }
        DodamDatePicker(
            state = datePickerState,
            onClickDate = { date, isValid ->
                datePickerState.selectedDate = date
            },
        )
        if (isShowBottomSheet) {
            DodamDatePickerBottomSheet(
                sheetState = sheetState,
                state = datePickerState,
                onDismissRequest = {
                    coroutineScope.launch {
                        isShowBottomSheet = false
                        sheetState.hide()
                    }
                },
                onClickDate = { date, isValid ->
                    coroutineScope.launch {
                        datePickerState.selectedDate = date
                    }
                },
                onClickSuccess = {}
            )
        }
    }
}