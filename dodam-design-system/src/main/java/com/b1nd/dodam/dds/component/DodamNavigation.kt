package com.b1nd.dodam.dds.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.b1nd.dodam.dds.component.NavigationBarTokens.NavigationBarHeight
import com.b1nd.dodam.dds.component.button.DodamIconButton
import com.b1nd.dodam.dds.foundation.DodamIcons
import com.b1nd.dodam.dds.theme.DodamTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun DodamNavigationBar(
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    indicatorColor: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = MaterialTheme.shapes.large,
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    navigationItems: ImmutableList<DodamNavigationItem>,
    onClickItem: (DodamNavigationItem) -> Unit,
) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    var selectedXOffset by remember { mutableFloatStateOf(43f) }
    val x by animateFloatAsState(targetValue = selectedXOffset, label = "")

    Surface(
        color = containerColor,
        contentColor = contentColor,
        shape = shape,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        modifier = modifier
    ) {
        Box(contentAlignment = Alignment.CenterStart) {
            Box(
                modifier = Modifier
                    .offset { IntOffset(x.toInt(), 0) }
                    .size(48.dp),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = indicatorColor,
                            shape = MaterialTheme.shapes.medium,
                        )
                        .size(40.dp),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(windowInsets)
                    .defaultMinSize(minHeight = NavigationBarHeight)
                    .selectableGroup(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    navigationItems.forEachIndexed { index, item ->
                        val animColor by animateColorAsState(
                            targetValue = if (selectedIndex == index) item.colors.selectedIconColor
                            else item.colors.unselectedIconColor,
                            animationSpec = tween(
                                durationMillis = 150,
                                easing = LinearEasing,
                            ),
                            label = "",
                        )

                        DodamIconButton(
                            onClick = {
                                selectedIndex = index
                                onClickItem(item)
                            },
                            modifier = modifier
                                .onGloballyPositioned {
                                    if (selectedIndex == index) {
                                        selectedXOffset = it.positionInRoot().x
                                    }
                                },
                            enabled = item.enabled
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = if (item.enabled) animColor else item.colors.disabledIconColor
                            )
                        }
                    }
                },
            )
        }
    }

}

@Composable
@Preview
private fun DodamNavigationBarPreview() {
    DodamTheme {
        DodamNavigationBar(
            navigationItems = persistentListOf(
                rememberDodamNavigationItem("home", DodamIcons.Home),
                rememberDodamNavigationItem("meal", DodamIcons.ForkAndKnife),
                rememberDodamNavigationItem("out", DodamIcons.DoorOpen),
                rememberDodamNavigationItem("nightstudy", DodamIcons.MoonPlus),
                rememberDodamNavigationItem("menu", DodamIcons.Menu),
            ),
            onClickItem = {

            },
        )
    }
}

data class DodamNavigationItem(
    val route: String,
    val icon: ImageVector,
    val enabled: Boolean,
    val colors: NavigationBarItemColors,
)

@Composable
fun rememberDodamNavigationItem(
    route: String,
    icon: ImageVector,
    enabled: Boolean = true,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.onPrimary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurface,
        disabledIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
    )
) = remember(route, icon, enabled, colors) {
    DodamNavigationItem(route, icon, enabled, colors)
}

internal object NavigationBarTokens {
    val NavigationBarHeight = 72.dp
}
