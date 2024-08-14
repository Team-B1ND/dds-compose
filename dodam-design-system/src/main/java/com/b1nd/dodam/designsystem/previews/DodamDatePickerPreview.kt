package com.b1nd.dodam.designsystem.previews

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.component.DodamDatePicker
import com.b1nd.dodam.designsystem.component.DodamDatePickerBottomSheet
import com.b1nd.dodam.designsystem.component.DodamDatePickerDialog
import com.b1nd.dodam.designsystem.component.rememberDodamDatePickerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0xFF232424)
private fun DodamDatePickerPreview() {
    val datePickerState = rememberDodamDatePickerState()
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()
    var isShowDialog by remember { mutableStateOf(true) }
    LaunchedEffect(key1 = true) {
        sheetState.show()
    }
    DodamTheme {
//        if (isShowDialog) {
//            DodamDatePickerDialog(
//                state = datePickerState,
//                onDismissRequest = {
//                    isShowDialog = false
//                },
//                onClickDate = { date, isValid ->
//                    datePickerState.selectedDate = date
//                },
//                onClickSuccess = {
//                    isShowDialog = false
//                }
//            )
//        }
        DodamDatePicker(
            state = datePickerState,
            onClickDate = { date, isValid ->
                Log.d("TAG", "DodamDatePickerPreview: $date")
                datePickerState.selectedDate = date
                Log.d("TAG", "DodamDatePickerPreview: $datePickerState")
            },
        )

//        DodamDatePickerBottomSheet(
//            sheetState = sheetState,
//            state = datePickerState,
//            onDismissRequest = {
//                coroutineScope.launch {
//                    sheetState.hide()
//                }
//            },
//            onClickDate = { date, isValid ->
//                coroutineScope.launch {
//                    datePickerState.selectedDate = date
//                }
//            },
//            onClickSuccess = {}
//        )
    }
}