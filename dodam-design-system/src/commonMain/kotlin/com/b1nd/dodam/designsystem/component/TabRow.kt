package com.b1nd.dodam.designsystem.component

import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import kotlinx.collections.immutable.ImmutableList

@Composable
fun DodamTabRow(
    modifier: Modifier = Modifier,
    tabs: ImmutableList<DodamTab>
) {
    val underlineColor = TabRowDefaults.UnderlineColor

    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .height(TabRowDefaults.DefaultTabHeight)
            .drawBehind {
                this.drawLine(
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    color = underlineColor,
                    strokeWidth = 1.5.dp.toPx()
                )
            }
            .padding(TabRowDefaults.TabRowHorizontalPadding)
    ) {
        val indicatorWidth = remember { maxWidth / tabs.size }
        val indicatorOffset by animateIntOffsetAsState(
            targetValue = IntOffset(
                x = with(LocalDensity.current) { (indicatorWidth * tabs.indexOfFirst { it.selected }).toPx() }.toInt(),
                y = with(LocalDensity.current) { (maxHeight - TabRowDefaults.IndicatorHeight).toPx() }.toInt()
            ),
            label = "",
            animationSpec = tween()
        )

        Box(
            modifier = Modifier
                .offset { indicatorOffset }
                .size(width = indicatorWidth, height = TabRowDefaults.IndicatorHeight)
                .background(
                    color = TabRowDefaults.IndicatorColor,
                )
        )

        Row(
            modifier = Modifier
                .selectableGroup(),
        ) {
            tabs.fastForEach { tab ->
                Box(
                    modifier = Modifier
                        .selectable(
                            selected = tab.selected,
                            onClick = tab.onClick,
                            enabled = tab.enabled,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberBounceIndication(showBackground = false),
                        )
                        .weight(1f)
                        .fillMaxHeight()
                        .alpha(if (tab.enabled) 1f else 0.5f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = tab.label,
                        style = TabRowDefaults.TabLabelStyle,
                        color = TabRowDefaults.SelectedTabLabelColor.takeIf { tab.selected }
                            ?: TabRowDefaults.UnselectedTabLabelColor,
                    )
                }
            }
        }
    }
}

@Immutable
data class DodamTab(
    val selected: Boolean,
    val label: String,
    val enabled: Boolean = true,
    val onClick: () -> Unit,
)

private object TabRowDefaults {
    val DefaultTabHeight = 50.dp
    val TabRowHorizontalPadding = PaddingValues(horizontal = 24.dp)
    val UnderlineColor @Composable get() = DodamTheme.colors.lineAlternative

    val IndicatorHeight = 2.dp
    val IndicatorColor @Composable get() = DodamTheme.colors.labelNormal

    val TabLabelStyle @Composable get() = DodamTheme.typography.headlineMedium()
    val SelectedTabLabelColor @Composable get() = DodamTheme.colors.labelNormal
    val UnselectedTabLabelColor @Composable get() = DodamTheme.colors.labelAssistive
}