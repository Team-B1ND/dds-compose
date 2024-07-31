package com.b1nd.dodam.designsystem.component

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.b1nd.dodam.designsystem.DodamTheme
import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
fun DodamSegmentedButton(
    modifier: Modifier = Modifier,
    segments: ImmutableList<DodamSegment>,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(SegmentedButtonDefaults.DefaultContainerHeight),
        color = SegmentedButtonDefaults.ContainerColor,
        shape = SegmentedButtonDefaults.ContainerShape,
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .padding(SegmentedButtonDefaults.ContainerPadding)
        ) {
            val segmentWidth = remember { maxWidth / segments.size }
            val indicatorOffset by animateIntOffsetAsState(
                targetValue = IntOffset(
                    x = with(LocalDensity.current) { (segmentWidth * segments.indexOfFirst { it.selected }).toPx() }.toInt(),
                    y = 0
                ),
                label = "",
            )
            Box(
                modifier = Modifier
                    .offset { indicatorOffset }
                    .width(segmentWidth)
                    .fillMaxHeight()
                    .background(
                        color = SegmentedButtonDefaults.SegmentColor,
                        shape = SegmentedButtonDefaults.SegmentShape,
                    ),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectableGroup(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                segments.fastForEach { segment ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .selectable(
                                selected = segment.selected,
                                onClick = segment.onClick,
                                enabled = segment.enabled,
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberBounceIndication(showBackground = false)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = segment.text,
                            style = SegmentedButtonDefaults.TextStyle,
                            color = SegmentedButtonDefaults.SelectedTextColor.takeIf { segment.selected }
                                ?: SegmentedButtonDefaults.UnselectedTextColor.takeIf { segment.enabled }
                                ?: SegmentedButtonDefaults.UnselectedTextColor.copy(alpha = 0.5f),
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0xFF232424)
private fun DodamSegmentedButtonPreview() {
    DodamTheme {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val texts = listOf(
            "First",
            "Second",
            "Third",
            "Fourth",
            "Fifth",
        )
        val items = List(5) { index ->
            DodamSegment(
                selected = selectedIndex == index,
                text = texts[index],
                onClick = { selectedIndex = index },
            )
        }.toImmutableList()

        DodamSegmentedButton(
            segments = items
        )
    }
}

@Immutable
data class DodamSegment(
    val selected: Boolean,
    val onClick: () -> Unit,
    val text: String,
    val enabled: Boolean = true,
)

private object SegmentedButtonDefaults {
    val ContainerColor @Composable get() = DodamTheme.colors.fillNeutral
    val ContainerShape @Composable get() = DodamTheme.shapes.medium
    val ContainerPadding = 4.dp
    val DefaultContainerHeight = 48.dp

    val SegmentColor @Composable get() = DodamTheme.colors.fillAssistive
    val SegmentShape @Composable get() = DodamTheme.shapes.small

    val SelectedTextColor @Composable get() = DodamTheme.colors.labelNormal
    val UnselectedTextColor @Composable get() = DodamTheme.colors.labelAssistive
    val TextStyle @Composable get() = DodamTheme.typography.headlineMedium
}
