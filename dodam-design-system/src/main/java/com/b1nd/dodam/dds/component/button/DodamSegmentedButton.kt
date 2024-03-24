package com.b1nd.dodam.dds.component.button

import android.content.res.Configuration
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.layout.layout
import androidx.compose.ui.node.LayoutModifierNode
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.platform.InspectorInfo
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.util.fastMap
import com.b1nd.dodam.dds.animation.bounceEffect
import com.b1nd.dodam.dds.style.BodyMedium
import com.b1nd.dodam.dds.theme.DodamTheme
import kotlinx.coroutines.launch

@Composable
fun DodamSegmentedButtonRow(
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    shape: Shape = MaterialTheme.shapes.medium,
    indicatorShape: Shape = MaterialTheme.shapes.small,
    contentPadding: PaddingValues = PaddingValues(4.dp),
    segments: @Composable () -> Unit,
) {
    val scope = remember {
        object : SegmentIndicatorScope, SegmentPositionsHolder {

            val segmentPositions = mutableStateOf<(List<SegmentPosition>)>(listOf())

            override fun Modifier.segmentIndicatorLayout(measure: MeasureScope.(Measurable, Constraints, List<SegmentPosition>) -> MeasureResult): Modifier {
                return this.layout { measurable: Measurable, constraints: Constraints ->
                    measure(
                        measurable,
                        constraints,
                        segmentPositions.value,
                    )
                }
            }

            override fun Modifier.segmentIndicatorOffset(
                selectedSegmentIndex: Int,
                matchContentSize: Boolean
            ): Modifier {
                return this.then(
                    SegmentIndicatorModifier(
                        segmentPositions,
                        selectedSegmentIndex,
                        matchContentSize
                    )
                )
            }

            override fun setSegmentPositions(positions: List<SegmentPosition>) {
                segmentPositions.value = positions
            }
        }
    }


    Surface(
        modifier = Modifier
            .selectableGroup(),
        color = containerColor,
        shape = shape,
    ) {
        Layout(
            modifier = modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(contentPadding),
            contents = listOf(
                segments,
                {
                    scope.run {
                        Surface(
                            modifier = Modifier
                                .segmentIndicatorOffset(selectedIndex),
                            color = Color.Transparent,
                            shape = indicatorShape,
                            shadowElevation = 4.dp,
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        MaterialTheme.colorScheme.surfaceContainerLow,
                                        indicatorShape
                                    )
                            )
                        }
                    }
                },
            )
        ) { (segmentMeasurables, indicatorMeasurables), constraints ->
            require(segmentMeasurables.size <= 5) { "Segments size must be less than 5" }

            val segmentButtonRowWidth = constraints.maxWidth
            val segmentButtonRowHeight = constraints.maxHeight
            val segmentCount = segmentMeasurables.size
            var segmentWidth = 0
            if (segmentCount > 0) {
                segmentWidth = (segmentButtonRowWidth / segmentCount)
            }

            scope.setSegmentPositions(List(segmentCount) { index ->
                val contentWidth =
                    minOf(
                        segmentMeasurables[index].maxIntrinsicWidth(segmentButtonRowHeight),
                        segmentWidth
                    ).toDp()
                val indicatorWidth = maxOf(contentWidth, 74.dp)

                SegmentPosition(segmentWidth.toDp() * index, segmentWidth.toDp(), indicatorWidth)
            })

            val segmentPlaceables = segmentMeasurables.fastMap {
                it.measure(
                    constraints.copy(
                        minWidth = segmentWidth,
                        maxWidth = segmentWidth,
                        minHeight = segmentButtonRowHeight,
                        maxHeight = segmentButtonRowHeight,
                    )
                )
            }

            val indicatorPlaceables = indicatorMeasurables.fastMap {
                it.measure(
                    constraints.copy(
                        minWidth = segmentWidth,
                        maxWidth = segmentWidth,
                        minHeight = segmentButtonRowHeight,
                        maxHeight = segmentButtonRowHeight,
                    )
                )
            }

            layout(segmentButtonRowWidth, segmentButtonRowHeight) {
                indicatorPlaceables.fastForEach {
                    it.placeRelative(0, segmentButtonRowHeight - it.height)
                }

                segmentPlaceables.fastForEachIndexed { index, placeable ->
                    placeable.placeRelative(index * segmentWidth, 0)
                }
            }
        }

    }
}

@Composable
fun DodamSegment(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedContentColor: Color = MaterialTheme.colorScheme.onSurface,
    unselectedContentColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable BoxScope.() -> Unit,
) {
    SegmentTransition(selectedContentColor, unselectedContentColor, selected) {
        Box(
            modifier = modifier
                .selectable(
                    selected = selected,
                    onClick = onClick,
                    enabled = enabled,
                    role = Role.Tab,
                    interactionSource = interactionSource,
                    indication = null
                )
                .fillMaxWidth()
                .then(if (enabled && !selected) Modifier.bounceEffect(MaterialTheme.colorScheme.secondary) else Modifier),
            contentAlignment = Alignment.Center,
            content = content
        )
    }
}

@Composable
private fun SegmentTransition(
    activeColor: Color,
    inactiveColor: Color,
    selected: Boolean,
    content: @Composable () -> Unit
) {
    val transition = updateTransition(selected, label = "")
    val color by transition.animateColor(
        transitionSpec = {
            if (false isTransitioningTo true) {
                tween(
                    durationMillis = 150,
                    delayMillis = 100,
                    easing = LinearEasing
                )
            } else {
                tween(
                    durationMillis = 100,
                    easing = LinearEasing
                )
            }
        }, label = ""
    ) {
        if (it) activeColor else inactiveColor
    }
    CompositionLocalProvider(
        LocalContentColor provides color,
        LocalTextStyle provides if (selected) MaterialTheme.typography.bodyLarge
        else MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
        content = content
    )
}


internal data class SegmentIndicatorModifier(
    val segmentPositionsState: State<List<SegmentPosition>>,
    val selectedTabIndex: Int,
    val followContentSize: Boolean,
) : ModifierNodeElement<SegmentIndicatorOffsetNode>() {

    override fun create(): SegmentIndicatorOffsetNode {
        return SegmentIndicatorOffsetNode(
            segmentPositionsState = segmentPositionsState,
            selectedSegmentIndex = selectedTabIndex,
            followContentSize = followContentSize,
        )
    }

    override fun update(node: SegmentIndicatorOffsetNode) {
        node.segmentPositionsState = segmentPositionsState
        node.selectedSegmentIndex = selectedTabIndex
        node.followContentSize = followContentSize
    }

    override fun InspectorInfo.inspectableProperties() {
        // Show nothing in the inspector.
    }
}

internal class SegmentIndicatorOffsetNode(
    var segmentPositionsState: State<List<SegmentPosition>>,
    var selectedSegmentIndex: Int,
    var followContentSize: Boolean
) : Modifier.Node(), LayoutModifierNode {

    private var offsetAnimatable: Animatable<Dp, AnimationVector1D>? = null
    private var widthAnimatable: Animatable<Dp, AnimationVector1D>? = null
    private var initialOffset: Dp? = null
    private var initialWidth: Dp? = null

    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        if (segmentPositionsState.value.isEmpty()) {
            return layout(0, 0) { }
        }

        val currentTabWidth = segmentPositionsState.value[selectedSegmentIndex].contentWidth
        if (followContentSize) {
            if (initialWidth != null) {
                val widthAnim =
                    widthAnimatable ?: Animatable(initialWidth!!, Dp.VectorConverter).also {
                        widthAnimatable = it
                    }

                if (currentTabWidth != widthAnim.targetValue) {
                    coroutineScope.launch { widthAnim.animateTo(currentTabWidth) }
                }
            } else {
                initialWidth = currentTabWidth
            }
        }

        val indicatorOffset = segmentPositionsState.value[selectedSegmentIndex].left

        if (initialOffset != null) {
            val offsetAnim =
                offsetAnimatable ?: Animatable(initialOffset!!, Dp.VectorConverter).also {
                    offsetAnimatable = it
                }

            if (indicatorOffset != offsetAnim.targetValue) {
                coroutineScope.launch { offsetAnim.animateTo(indicatorOffset) }
            }
        } else {
            initialOffset = indicatorOffset
        }

        val offset = offsetAnimatable?.value ?: indicatorOffset

        val placeable = measurable.measure(
            if (followContentSize) {
                val width = widthAnimatable?.value ?: currentTabWidth
                constraints.copy(minWidth = width.roundToPx(), maxWidth = width.roundToPx())
            } else {
                constraints
            }
        )

        return layout(placeable.width, constraints.maxHeight) {
            placeable.place(offset.roundToPx(), constraints.maxHeight - placeable.height)
        }
    }
}

interface SegmentIndicatorScope {

    fun Modifier.segmentIndicatorLayout(
        measure: MeasureScope.(
            Measurable,
            Constraints,
            List<SegmentPosition>,
        ) -> MeasureResult
    ): Modifier

    fun Modifier.segmentIndicatorOffset(
        selectedSegmentIndex: Int,
        matchContentSize: Boolean = false
    ): Modifier
}

internal interface SegmentPositionsHolder {

    fun setSegmentPositions(positions: List<SegmentPosition>)
}

data class SegmentPosition(
    val left: Dp,
    val width: Dp,
    val contentWidth: Dp,
    val right: Dp = left + width
)

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun DodamSegmentedButtonPreview() {
    DodamTheme {
        var selectedTabIndex by remember { mutableIntStateOf(0) }
        DodamSegmentedButtonRow(
            selectedIndex = selectedTabIndex, ) {
            DodamSegment(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }) {
                BodyMedium(text = "Label")
            }
            DodamSegment(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }) {
                BodyMedium(text = "Label")
            }
            DodamSegment(selected = selectedTabIndex == 2, onClick = { selectedTabIndex = 2 }) {
                BodyMedium(text = "Label")
            }
        }
    }
}
