package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import kotlinx.serialization.json.JsonNull.content

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DodamModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: @Composable ColumnScope.() -> Unit,
    content: @Composable ColumnScope.() -> Unit,
    titlePaddingValues: PaddingValues = PaddingValues(
        top = 16.dp,
        bottom = 16.dp
    ),
    contentPaddingValues: PaddingValues = PaddingValues(
        start = 16.dp,
        end = 16.dp,
        bottom = 16.dp
    ),
    containerColor: Color = DodamTheme.colors.backgroundNormal,
    shape: Shape = DodamTheme.shapes.extraLarge.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
    space: Dp = 4.dp,
    sheetState: SheetState = rememberModalBottomSheetState(),
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
        modifier = modifier,
        containerColor = containerColor,
        shape = shape,
        dragHandle = {
            Surface(
                modifier = Modifier.padding(titlePaddingValues),
                color = containerColor
            ) {
                Box(
                    modifier = Modifier
                        .width(64.dp)
                        .height(6.dp)
                        .background(
                            color = DodamTheme.colors.fillAlternative,
                            shape = DodamTheme.shapes.extraSmall
                        )
                )
            }
        },
        content = {
            Column(
                modifier = Modifier.padding(contentPaddingValues)
            ) {
                title()
                Spacer(modifier = Modifier.height(space))
                content()
                Spacer(modifier = Modifier.navigationBarsPadding())
            }
        }
    )
}