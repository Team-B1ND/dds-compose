package com.b1nd.dodam.designsystem.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import com.b1nd.dodam.designsystem.foundation.DodamIcons
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun DodamNavigationBar(
    modifier: Modifier = Modifier,
    type: NavigationBarType = NavigationBarType.Normal,
    items: ImmutableList<DodamNavigationBarItem>,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        color = NavigationBarDefaults.ContainerColor,
        shape = NavigationBarDefaults.ContainerShape,
        border = when (type) {
            NavigationBarType.Normal -> null
            NavigationBarType.Border -> NavigationBarDefaults.BorderStroke
        }
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(vertical = 12.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            val spaceEvenlySize =
                remember { (maxWidth - (NavigationBarDefaults.IndicatorSize * items.size)) / (items.size + 1) }
            val indicatorOffset by animateIntOffsetAsState(
                targetValue = IntOffset(
                    x = with(LocalDensity.current) { ((NavigationBarDefaults.IndicatorSize + spaceEvenlySize) * items.indexOfFirst { it.selected } + spaceEvenlySize).toPx() }.toInt(),
                    y = 0
                ),
                label = ""
            )
            Box(
                modifier = Modifier
                    .offset { indicatorOffset }
                    .size(NavigationBarDefaults.IndicatorSize)
                    .background(
                        color = NavigationBarDefaults.IndicatorColor,
                        shape = NavigationBarDefaults.IndicatorShape
                    )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                items.fastForEach { item ->
                    val color by animateColorAsState(
                        targetValue = if (item.selected) {
                            NavigationBarDefaults.SelectedContentColor
                        } else {
                            NavigationBarDefaults.UnselectedContentColor
                        },
                        label = ""
                    )
                    Box(
                        modifier = Modifier
                            .size(NavigationBarDefaults.InteractiveIconSize)
                            .clickable(
                                enabled = item.enable,
                                onClick = item.onClick,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberBounceIndication(NavigationBarDefaults.IndicatorShape)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = item.icon.value,
                            contentDescription = null,
                            modifier = Modifier.size(NavigationBarDefaults.IconSize),
                            tint = color
                        )
                    }
                }
            }
        }
    }
}

@Stable
enum class NavigationBarType {
    Normal,
    Border
}

@Immutable
data class DodamNavigationBarItem(
    val selected: Boolean,
    val icon: DodamIcons,
    val enable: Boolean = true,
    val onClick: () -> Unit
)

private object NavigationBarDefaults {
    val IconSize = 24.dp
    val IndicatorSize = 40.dp
    val InteractiveIconSize = 40.dp

    val ContainerColor @Composable get() = DodamTheme.colors.backgroundNormal
    val UnselectedContentColor @Composable get() = DodamTheme.colors.labelNormal
    val SelectedContentColor @Composable get() = DodamTheme.colors.staticWhite
    val IndicatorColor @Composable get() = DodamTheme.colors.primaryNormal

    val ContainerShape @Composable get() = DodamTheme.shapes.large
    val IndicatorShape @Composable get() = DodamTheme.shapes.medium

    val BorderStroke @Composable get() = BorderStroke(1.dp, DodamTheme.colors.lineNormal)
}