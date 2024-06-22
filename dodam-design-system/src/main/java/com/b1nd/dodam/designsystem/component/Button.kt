package com.b1nd.dodam.designsystem.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import com.b1nd.dodam.designsystem.foundation.DodamIcons

@Composable
fun DodamButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    buttonSize: ButtonSize = ButtonSize.Large,
    buttonRole: ButtonRole = ButtonRole.Primary,
    leadingIcon: DodamIcons? = null,
    trailingIcon: DodamIcons? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val buttonColors = buttonRole.buttonColors()
    val buttonConfig = buttonSize.buttonConfig()

    Surface(
        modifier = modifier
            .clickable(
                onClick = onClick,
                enabled = enabled,
                interactionSource = interactionSource,
                indication = rememberBounceIndication(buttonConfig.shape),
            ),
        shape = buttonConfig.shape,
        color = buttonColors.containerColor,
        contentColor = buttonColors.contentColor,
    ) {
        Row(
            modifier = Modifier
                .padding(buttonConfig.padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                buttonConfig.contentSpacing,
                Alignment.CenterHorizontally
            ),
        ) {
            leadingIcon?.let { icon ->
                Icon(
                    modifier = Modifier.size(buttonConfig.iconSize),
                    imageVector = icon.value,
                    contentDescription = "Leading Icon",
                )
            }

            Text(
                text = text,
                style = buttonConfig.textStyle,
            )

            trailingIcon?.let { icon ->
                Icon(
                    modifier = Modifier.size(buttonConfig.iconSize),
                    imageVector = icon.value,
                    contentDescription = "Trailing Icon",
                )
            }
        }
    }
}

@Composable
@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
private fun DodamButtonPreview() {
    DodamTheme {
        DodamButton(
            onClick = {},
            text = "Button",
        )
    }
}

enum class ButtonRole {
    Primary,
    Secondary,
    Assistive,
}

enum class ButtonSize {
    Large,
    Medium,
    Small,
}

@Immutable
private data class ButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
)

@Immutable
private data class ButtonConfig(
    val shape: CornerBasedShape,
    val padding: PaddingValues,
    val contentSpacing: Dp,
    val iconSize: Dp,
    val textStyle: TextStyle,
)

@Composable
private fun ButtonRole.buttonColors(): ButtonColors {
    val colors = DodamTheme.colors

    return when (this) {
        ButtonRole.Primary -> ButtonColors(
            containerColor = colors.primaryNormal,
            contentColor = colors.staticWhite,
            disabledContainerColor = colors.primaryAssistive,
            disabledContentColor = colors.labelDisabled,
        )

        ButtonRole.Secondary -> ButtonColors(
            containerColor = colors.primaryAssistive,
            contentColor = colors.primaryNormal,
            disabledContainerColor = colors.labelDisabled,
            disabledContentColor = colors.labelDisabled,
        )

        ButtonRole.Assistive -> ButtonColors(
            containerColor = colors.componentStrong,
            contentColor = colors.labelNeutral,
            disabledContainerColor = colors.labelDisabled,
            disabledContentColor = colors.labelDisabled,
        )
    }
}


@Composable
private fun ButtonSize.buttonConfig(): ButtonConfig {
    return when (this) {
        ButtonSize.Large -> ButtonConfig(
            shape = ButtonDefaults.LargeButtonShape,
            padding = ButtonDefaults.LargeButtonPadding,
            contentSpacing = ButtonDefaults.LargeButtonContentSpacing,
            iconSize = ButtonDefaults.LargeButtonIconSize,
            textStyle = ButtonDefaults.LargeButtonTextStyle,
        )

        ButtonSize.Medium -> ButtonConfig(
            shape = ButtonDefaults.MediumButtonShape,
            padding = ButtonDefaults.MediumButtonPadding,
            contentSpacing = ButtonDefaults.MediumButtonContentSpacing,
            iconSize = ButtonDefaults.MediumButtonIconSize,
            textStyle = ButtonDefaults.MediumButtonTextStyle,
        )

        ButtonSize.Small -> ButtonConfig(
            shape = ButtonDefaults.SmallButtonShape,
            padding = ButtonDefaults.SmallButtonPadding,
            contentSpacing = ButtonDefaults.SmallButtonContentSpacing,
            iconSize = ButtonDefaults.SmallButtonIconSize,
            textStyle = ButtonDefaults.SmallButtonTextStyle,
        )
    }
}

private object ButtonDefaults {
    val LargeButtonShape @Composable get() = DodamTheme.shapes.medium
    val MediumButtonShape @Composable get() = DodamTheme.shapes.small
    val SmallButtonShape @Composable get() = DodamTheme.shapes.xSmall

    val LargeButtonPadding = PaddingValues(vertical = 13.dp, horizontal = 28.dp)
    val MediumButtonPadding = PaddingValues(vertical = 9.dp, horizontal = 20.dp)
    val SmallButtonPadding = PaddingValues(vertical = 7.dp, horizontal = 12.dp)

    val LargeButtonContentSpacing = 6.dp
    val MediumButtonContentSpacing = 5.dp
    val SmallButtonContentSpacing = 4.dp

    val LargeButtonIconSize = 20.dp
    val MediumButtonIconSize = 18.dp
    val SmallButtonIconSize = 16.dp

    val LargeButtonTextStyle @Composable get() = DodamTheme.typography.body1Strong
    val MediumButtonTextStyle @Composable get() = DodamTheme.typography.body2Strong
    val SmallButtonTextStyle @Composable get() = DodamTheme.typography.body3Strong
}
