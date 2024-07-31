package com.b1nd.dodam.designsystem.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme

@Composable
fun DodamDialog(
    confirmButton: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    body: String? = null,
    text: String = "닫기",
    textType: TextButtonType = TextButtonType.Primary,
) {
    DodamDialogImpl(
        modifier = modifier
            .width(DialogDefaults.DialogDefaultWidth),
        title = title,
        body = body,
        content = {
            DodamTextButton(
                modifier = Modifier.align(Alignment.End),
                onClick = confirmButton,
                text = text,
                type = textType,
            )
        }
    )
}

@Composable
fun DodamButtonDialog(
    confirmButton: () -> Unit,
    dismissButton: () -> Unit,
    title: String,
    modifier: Modifier = Modifier,
    body: String? = null,
    confirmButtonText: String = "확인",
    dismissButtonText: String = "취소",
    confirmButtonRole: ButtonRole = ButtonRole.Primary,
    dismissButtonRole: ButtonRole = ButtonRole.Assistive,
) {
    DodamDialogImpl(
        modifier = modifier
            .width(DialogDefaults.DialogDefaultWidth),
        title = title,
        body = body,
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                DodamButton(
                    modifier = Modifier.weight(1f),
                    onClick = dismissButton,
                    text = dismissButtonText,
                    buttonRole = dismissButtonRole,
                )

                DodamButton(
                    modifier = Modifier.weight(1f),
                    onClick = confirmButton,
                    text = confirmButtonText,
                    buttonRole = confirmButtonRole,
                )
            }
        }
    )
}

@Composable
@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
private fun DodamDialogPreview() {
    DodamTheme {
        Column {
            DodamDialog(
                confirmButton = {},
                title = "제목을 입력해주세요",
                body = "본문을 입력해주세요",
            )

            Spacer(modifier = Modifier.height(24.dp))

            DodamButtonDialog(
                confirmButton = {},
                dismissButton = {},
                title = "제목을 입력해주세요",
                body = "본문을 입력해주세요",
            )
        }
    }
}

@Composable
private fun DodamDialogImpl(
    modifier: Modifier,
    title: String,
    body: String?,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        modifier = modifier
            .sizeIn(minWidth = DialogDefaults.DialogMinWidth, maxWidth = DialogDefaults.DialogMaxWidth),
        color = DialogDefaults.DialogColor,
        shape = DialogDefaults.DialogShape
    ) {
        Column(
            modifier = Modifier.padding(DialogDefaults.DialogContainerPadding),
            verticalArrangement = Arrangement.spacedBy(DialogDefaults.PaddingBetweenContentAndActions)
        ) {
            Column(
                modifier = Modifier.padding(DialogDefaults.DialogContentPadding),
                verticalArrangement = Arrangement.spacedBy(DialogDefaults.PaddingBetweenTitleAndBody)
            ) {
                Text(
                    text = title,
                    style = DialogDefaults.TitleStyle,
                    color = DialogDefaults.TitleColor
                )
                body?.let {
                    Text(
                        text = it,
                        style = DialogDefaults.BodyStyle,
                        color = DialogDefaults.BodyColor
                    )
                }
            }

            content()
        }
    }
}

private object DialogDefaults {
    val DialogColor @Composable get() = DodamTheme.colors.backgroundNormal
    val DialogMinWidth = 280.dp
    val DialogMaxWidth = 360.dp
    val DialogDefaultWidth = 320.dp
    val DialogShape @Composable get() = DodamTheme.shapes.extraLarge

    val DialogContainerPadding = PaddingValues(18.dp)
    val PaddingBetweenContentAndActions = 24.dp

    val TitleStyle @Composable get() = DodamTheme.typography.heading1Bold
    val TitleColor @Composable get() = DodamTheme.colors.labelStrong

    val BodyStyle @Composable get() = DodamTheme.typography.body1Medium
    val BodyColor @Composable get() = DodamTheme.colors.labelAlternative

    val DialogContentPadding = PaddingValues(6.dp)
    val PaddingBetweenTitleAndBody = 12.dp
}