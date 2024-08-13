package com.b1nd.dodam.designsystem.previews

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamTimePickerBottomSheet
import com.b1nd.dodam.designsystem.component.DodamTimePickerDialog
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun DodamDatePickerPreview() {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()
    var isShowDialog by remember { mutableStateOf(true) }
    var isShowBottomSheet by remember { mutableStateOf(true) }


    DodamTheme {
        if (isShowDialog) {
            DodamTimePickerDialog(
                onSelectTime = { hour, minute ->

                },
                onDismissRequest = {
                    isShowDialog = false
                }
            )
        }
        if (isShowBottomSheet) {
            DodamTimePickerBottomSheet(
                sheetState = sheetState,
                onDismissRequest = {
                    isShowBottomSheet = false
                    coroutineScope.launch {
                        sheetState.hide()
                    }
                },
                onSelectTime = { hour, minute -> }
            )
        }
    }
}
