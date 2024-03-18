package com.b1nd.dodam.dds.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.animation.bounceClick
import com.b1nd.dodam.dds.foundation.DodamColor
import com.b1nd.dodam.dds.foundation.DodamShape
import com.b1nd.dodam.dds.style.HomeIcon
import com.b1nd.dodam.dds.theme.DodamTheme

@Composable
fun DodamIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: IconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = Color.Unspecified,
        contentColor = LocalContentColor.current,
        disabledContainerColor = Color.Unspecified,
        disabledContentColor = Color.Unspecified
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .minimumInteractiveComponentSize()
            .size(IconButtonTokens.StateLayerSize)
            .clip(IconButtonTokens.StateLayerShape)
            .bounceClick(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource
            )
            .background(color = if (enabled) colors.containerColor else colors.disabledContainerColor),
        contentAlignment = Alignment.Center
    ) {
        val contentColor = if (enabled) colors.contentColor else colors.disabledContentColor
        CompositionLocalProvider(LocalContentColor provides contentColor, content = content)
    }
}

@Composable
@Preview
fun DodamIconButtonPreview() {
    DodamTheme {
        DodamIconButton(onClick = { /*TODO*/ }) {
            HomeIcon()
        }
    }
}

internal object IconButtonTokens {
    val StateLayerShape = DodamShape.Large
    val StateLayerSize = 44.0.dp
}

