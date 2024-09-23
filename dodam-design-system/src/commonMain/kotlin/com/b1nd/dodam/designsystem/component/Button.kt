package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import com.b1nd.dodam.designsystem.foundation.DodamIcons
import com.b1nd.dodam.designsystem.internal.`if`
import org.jetbrains.compose.ui.tooling.preview.Preview

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
    loading: Boolean = false,
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
            )
            .`if`(!enabled) {
                alpha(0.5f)
            },
        shape = buttonConfig.shape,
        color = buttonColors.containerColor,
        contentColor = buttonColors.contentColor,
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize(minHeight = buttonConfig.minHeight)
                .padding(buttonConfig.padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                buttonConfig.contentSpacing,
                Alignment.CenterHorizontally
            ),
        ) {
            if (loading) {
                DodamLoadingDots()
            } else {
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
}

@Stable
enum class ButtonRole {
    Primary,
    Secondary,
    Assistive,
    Negative,
}

@Stable
enum class ButtonSize {
    Large,
    Medium,
    Small,
}

@Immutable
private data class ButtonColors(
    val containerColor: Color,
    val contentColor: Color,
)

@Immutable
private data class ButtonConfig(
    val shape: CornerBasedShape,
    val padding: PaddingValues,
    val minHeight: Dp,
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
        )

        ButtonRole.Secondary -> ButtonColors(
            containerColor = colors.primaryAssistive,
            contentColor = colors.primaryNormal,
        )

        ButtonRole.Assistive -> ButtonColors(
            containerColor = colors.fillNormal,
            contentColor = colors.labelNeutral,
        )
        ButtonRole.Negative ->{
            ButtonColors(
                containerColor = colors.statusNegative,
                contentColor = colors.staticWhite,
            )
        }
    }
}


@Composable
private fun ButtonSize.buttonConfig(): ButtonConfig {
    return when (this) {
        ButtonSize.Large -> ButtonConfig(
            shape = ButtonDefaults.LargeButtonShape,
            padding = ButtonDefaults.LargeButtonPadding,
            minHeight = 48.dp,
            contentSpacing = ButtonDefaults.LargeButtonContentSpacing,
            iconSize = ButtonDefaults.LargeButtonIconSize,
            textStyle = ButtonDefaults.LargeButtonTextStyle,
        )

        ButtonSize.Medium -> ButtonConfig(
            shape = ButtonDefaults.MediumButtonShape,
            padding = ButtonDefaults.MediumButtonPadding,
            minHeight = 38.dp,
            contentSpacing = ButtonDefaults.MediumButtonContentSpacing,
            iconSize = ButtonDefaults.MediumButtonIconSize,
            textStyle = ButtonDefaults.MediumButtonTextStyle,
        )

        ButtonSize.Small -> ButtonConfig(
            shape = ButtonDefaults.SmallButtonShape,
            padding = ButtonDefaults.SmallButtonPadding,
            minHeight = 32.dp,
            contentSpacing = ButtonDefaults.SmallButtonContentSpacing,
            iconSize = ButtonDefaults.SmallButtonIconSize,
            textStyle = ButtonDefaults.SmallButtonTextStyle,
        )
    }
}

private object ButtonDefaults {
    val LargeButtonShape @Composable get() = DodamTheme.shapes.medium
    val MediumButtonShape @Composable get() = DodamTheme.shapes.small
    val SmallButtonShape @Composable get() = DodamTheme.shapes.extraSmall

    val LargeButtonPadding = PaddingValues(vertical = 13.dp, horizontal = 28.dp)
    val MediumButtonPadding = PaddingValues(vertical = 9.dp, horizontal = 20.dp)
    val SmallButtonPadding = PaddingValues(vertical = 7.dp, horizontal = 12.dp)

    val LargeButtonContentSpacing = 6.dp
    val MediumButtonContentSpacing = 5.dp
    val SmallButtonContentSpacing = 4.dp

    val LargeButtonIconSize = 20.dp
    val MediumButtonIconSize = 18.dp
    val SmallButtonIconSize = 16.dp

    val LargeButtonTextStyle @Composable get() = DodamTheme.typography.body1Bold()
    val MediumButtonTextStyle @Composable get() = DodamTheme.typography.body2Bold()
    val SmallButtonTextStyle @Composable get() = DodamTheme.typography.caption1Bold()
}


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
        }
    }
}
