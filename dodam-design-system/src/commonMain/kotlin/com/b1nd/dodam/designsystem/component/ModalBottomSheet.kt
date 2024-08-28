package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DodamModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: @Composable ColumnScope.() -> Unit,
    content: @Composable ColumnScope.() -> Unit,
    containerColor: Color = DodamTheme.colors.backgroundNormal,
    shape: Shape = DodamTheme.shapes.extraLarge,
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
                modifier = Modifier.padding(
                    top = 24.dp,
                    bottom = 16.dp
                ),
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
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 24.dp
                    )
            ) {
                title()
                Spacer(modifier = Modifier.height(space))
                content()
                Spacer(modifier = Modifier.navigationBarsPadding())
            }
        }
    )
}