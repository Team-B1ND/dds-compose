package com.b1nd.dodam.dds.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
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
            .size(44.0.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(color = if (enabled) colors.containerColor else colors.disabledContainerColor)
            .bounceClick(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource
            ),
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
