package com.b1nd.dodam.designsystem.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication

@Composable
fun DodamTextButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    size: TextButtonSize = TextButtonSize.Large,
    type: TextButtonType = TextButtonType.Normal,
    enabled: Boolean = true,
    showUnderline: Boolean = false
) {
    val color = when (type) {
        TextButtonType.Primary -> TextButtonDefaults.PrimaryTextColor
        TextButtonType.Normal -> TextButtonDefaults.NormalTextColor
        TextButtonType.Assistive -> TextButtonDefaults.AssistiveTextColor
    }

    val textButtonConfig = when (size) {
        TextButtonSize.Large -> TextButtonConfig(
            padding = TextButtonDefaults.LargeButtonPadding,
            shape =TextButtonDefaults.LargeButtonShape,
            textStyle = TextButtonDefaults.LargeTextStyle,
        )

        TextButtonSize.Medium -> TextButtonConfig(
            padding = TextButtonDefaults.MediumButtonPadding,
            shape =TextButtonDefaults.MediumButtonShape,
            textStyle = TextButtonDefaults.MediumTextStyle,
        )

        TextButtonSize.Small -> TextButtonConfig(
            padding = TextButtonDefaults.SmallButtonPadding,
            shape =TextButtonDefaults.SmallButtonShape,
            textStyle = TextButtonDefaults.SmallTextStyle,
        )
    }

    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                enabled = enabled,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberBounceIndication(textButtonConfig.shape)
            )
            .padding(textButtonConfig.padding),
    ) {
        Text(
            text = text,
            style = textButtonConfig.textStyle,
            color = color,
            textDecoration = if (showUnderline) TextDecoration.Underline else null,
        )
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF5F5F5)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0xFF232424)
private fun DodamTextButtonPreview() {
    DodamTheme {
        DodamTextButton(onClick = { /*TODO*/ }, text = "Text Button")
    }
}

@Stable
enum class TextButtonSize {
    Large,
    Medium,
    Small,
}

@Stable
enum class TextButtonType {
    Primary,
    Normal,
    Assistive,
}

@Immutable
private data class TextButtonConfig(
    val padding: PaddingValues,
    val shape: CornerBasedShape,
    val textStyle: TextStyle,
)

private object TextButtonDefaults {
    val PrimaryTextColor @Composable get() = DodamTheme.colors.primaryNormal
    val NormalTextColor @Composable get() = DodamTheme.colors.labelNormal
    val AssistiveTextColor @Composable get() = DodamTheme.colors.labelAssistive

    val LargeButtonPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
    val MediumButtonPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
    val SmallButtonPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)

    val LargeButtonShape @Composable get() = DodamTheme.shapes.medium
    val MediumButtonShape @Composable get() = DodamTheme.shapes.small
    val SmallButtonShape @Composable get() = DodamTheme.shapes.extraSmall

    val LargeTextStyle @Composable get() = DodamTheme.typography.body1Bold
    val MediumTextStyle @Composable get() = DodamTheme.typography.body2Bold
    val SmallTextStyle @Composable get() = DodamTheme.typography.caption1Bold
}