package com.b1nd.dodam.dds.component

import android.content.res.Configuration
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.LocalContentColor
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
import androidx.compose.ui.semantics.selected
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.util.fastMap
import com.b1nd.dodam.dds.animation.bounceClick
import com.b1nd.dodam.dds.style.DoorOpenIcon
import com.b1nd.dodam.dds.style.ForkAndKnifeIcon
import com.b1nd.dodam.dds.style.HomeIcon
import com.b1nd.dodam.dds.style.MenuIcon
import com.b1nd.dodam.dds.style.MoonPlusIcon
import com.b1nd.dodam.dds.theme.DodamTheme
import kotlinx.coroutines.launch


@Composable
fun DodamNavigationBar(
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    shape: Shape = MaterialTheme.shapes.large,
    indicatorShape: Shape = MaterialTheme.shapes.medium,
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    border: BorderStroke? = null,
    navItems: @Composable () -> Unit,
) {
    val scope = remember {
        object : NavigationIndicatorScope, NavigationItemPositionsHolder {

            val navItemPositions = mutableStateOf<(List<NavigationItemPosition>)>(listOf())

            override fun Modifier.navigationIndicatorLayout(measure: MeasureScope.(Measurable, Constraints, List<NavigationItemPosition>) -> MeasureResult): Modifier {
                return this.layout { measurable: Measurable, constraints: Constraints ->
                    measure(
                        measurable,
                        constraints,
                        navItemPositions.value,
                    )
                }
            }

            override fun Modifier.navigationIndicatorOffset(
                selectedNavigationIndex: Int,
                matchContentSize: Boolean
            ): Modifier {
                return this.then(
                    NavigationItemIndicatorModifier(
                        navItemPositions,
                        selectedNavigationIndex,
                        matchContentSize
                    )
                )
            }

            override fun setNavigationItemPositions(positions: List<NavigationItemPosition>) {
                navItemPositions.value = positions
            }
        }
    }


    Surface(
        modifier = Modifier
            .selectableGroup(),
        color = containerColor,
        shape = shape,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
    ) {
        Layout(
            modifier = modifier
                .fillMaxWidth()
                .height(72.dp),
            contents = listOf(
                navItems,
                {
                    scope.run {
                        Surface(
                            modifier = Modifier
                                .size(44.dp)
                                .navigationIndicatorOffset(selectedIndex),
                            color = Color.Transparent,
                            shape = indicatorShape,
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(
                                        MaterialTheme.colorScheme.primary,
                                        indicatorShape
                                    )
                            )
                        }
                    }
                },
            )
        ) { (navItemMeasurables, indicatorMeasurables), constraints ->
            require(navItemMeasurables.size <= 5) { "Segments size must be less than 5" }

            val navigationBarWidth = constraints.maxWidth
            val navigationBarHeight = constraints.maxHeight
            val navItemCount = navItemMeasurables.size
            var navItemWidth = 100
            if (navItemCount > 0) {
                navItemWidth = (navigationBarWidth / navItemCount)
            }

            scope.setNavigationItemPositions(List(navItemCount) { index ->
                val indicatorWidth = 48.dp

                NavigationItemPosition(navItemWidth.toDp() * index, navItemWidth.toDp(), indicatorWidth)
            })

            val navItemPlaceables = navItemMeasurables.fastMap {
                it.measure(Constraints())
            }

            val indicatorPlaceables = indicatorMeasurables.fastMap {
                it.measure(Constraints())
            }

            layout(navigationBarWidth, navigationBarHeight) {
                indicatorPlaceables.fastForEach {
                    it.placeRelative((navItemWidth - it.width) / 2, (navigationBarHeight - it.height) / 2)
                }

                navItemPlaceables.fastForEachIndexed { index, placeable ->
                    placeable.placeRelative((navItemWidth * index) + ((navItemWidth - placeable.width) / 2), (navigationBarHeight - placeable.height) / 2)
                }
            }
        }

    }
}

@Composable
fun DodamNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selectedContentColor: Color = MaterialTheme.colorScheme.onPrimary,
    unselectedContentColor: Color = MaterialTheme.colorScheme.onSurface,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable BoxScope.() -> Unit,
) {
    NavigationItemTransition(selectedContentColor, unselectedContentColor, selected) {
        Box(
            modifier = modifier
                .size(48.dp)
                .bounceClick(
                    onClick = onClick,
                    enabled = enabled && !selected,
                    role = Role.Tab,
                    interactionSource = interactionSource,
                    indication = null
                )
                .semantics {
                    this.selected = selected
                }
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
            content = content
        )
    }
}

@Composable
private fun NavigationItemTransition(
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
                    delayMillis = 0,
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
        content = content
    )
}


internal data class NavigationItemIndicatorModifier(
    val navItemPositionsState: State<List<NavigationItemPosition>>,
    val selectedNavItemIndex: Int,
    val followContentSize: Boolean,
) : ModifierNodeElement<NavigationIndicatorOffsetNode>() {

    override fun create(): NavigationIndicatorOffsetNode {
        return NavigationIndicatorOffsetNode(
            navItemPositionsState = navItemPositionsState,
            selectedNavItemIndex = selectedNavItemIndex,
            followContentSize = followContentSize,
        )
    }

    override fun update(node: NavigationIndicatorOffsetNode) {
        node.navItemPositionsState = navItemPositionsState
        node.selectedNavItemIndex = selectedNavItemIndex
        node.followContentSize = followContentSize
    }

    override fun InspectorInfo.inspectableProperties() {
        // Show nothing in the inspector.
    }
}

internal class NavigationIndicatorOffsetNode(
    var navItemPositionsState: State<List<NavigationItemPosition>>,
    var selectedNavItemIndex: Int,
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
        if (navItemPositionsState.value.isEmpty()) {
            return layout(0, 0) { }
        }

        val currentTabWidth = navItemPositionsState.value[selectedNavItemIndex].contentWidth
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

        val indicatorOffset = navItemPositionsState.value[selectedNavItemIndex].left

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

interface NavigationIndicatorScope {

    fun Modifier.navigationIndicatorLayout(
        measure: MeasureScope.(
            Measurable,
            Constraints,
            List<NavigationItemPosition>,
        ) -> MeasureResult
    ): Modifier

    fun Modifier.navigationIndicatorOffset(
        selectedNavigationIndex: Int,
        matchContentSize: Boolean = false
    ): Modifier
}

internal interface NavigationItemPositionsHolder {

    fun setNavigationItemPositions(positions: List<NavigationItemPosition>)
}

data class NavigationItemPosition(
    val left: Dp,
    val width: Dp,
    val contentWidth: Dp,
    val right: Dp = left + width
)

@Composable
@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
private fun DodamSegmentedButtonPreview() {
    DodamTheme {
        var selectedTabIndex by remember { mutableIntStateOf(0) }

        DodamNavigationBar(
            selectedIndex = selectedTabIndex
        ) {

            DodamNavigationBarItem(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }) {
                HomeIcon()
            }

            DodamNavigationBarItem(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }) {
                ForkAndKnifeIcon()
            }

            DodamNavigationBarItem(selected = selectedTabIndex == 2, onClick = { selectedTabIndex = 2 }) {
                DoorOpenIcon()
            }

            DodamNavigationBarItem(selected = selectedTabIndex == 3, onClick = { selectedTabIndex = 3 }) {
                MoonPlusIcon()
            }

            DodamNavigationBarItem(selected = selectedTabIndex == 4, onClick = { selectedTabIndex = 4 }) {
                MenuIcon()
            }
        }
    }
}
