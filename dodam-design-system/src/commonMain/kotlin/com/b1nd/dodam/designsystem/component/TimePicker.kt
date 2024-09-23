package com.b1nd.dodam.designsystem.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.b1nd.dodam.designsystem.DodamTheme
import kotlinx.collections.immutable.toImmutableList

@Composable
fun DodamTimePickerDialog(
    modifier: Modifier = Modifier,
    startTime: Int = 1,
    startMinute: Int = 0,
    titleText: String = "외출 일시",
    buttonText: String = "선택",
    onSelectTime: (hour: Int, minute: Int) -> Unit,
    onDismissRequest: () -> Unit,
) {
    var chooseHour by remember { mutableIntStateOf(startTime) }
    var chooseMinute by remember { mutableIntStateOf(startMinute) }

    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Surface(
            modifier = modifier,
            color = TimePickerDefaults.ContainerColor,
            shape = RoundedCornerShape(28.dp),
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
            ) {
                Text(
                    text = titleText,
                    color = TimePickerDefaults.TitleTextColor,
                    style = TimePickerDefaults.TitleTextStyle,
                )
                Spacer(modifier = Modifier.height(16.dp))
                DodamTimePicker(
                    startTime = startTime,
                    startMinute = startMinute,
                    onHourChanged = {
                        chooseHour = it
                    },
                    onMinChanged =  {
                        chooseMinute = it
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    DodamTextButton(
                        onClick = {
                            onSelectTime(chooseHour, chooseMinute)
                        },
                        text = buttonText,
                        size = TextButtonSize.Large,
                        type = TextButtonType.Primary
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DodamTimePickerBottomSheet(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    sheetState: SheetState = rememberModalBottomSheetState(),
    startTime: Int = 1,
    startMinute: Int = 0,
    titleText: String = "외출 일시",
    buttonText: String = "선택",
    onSelectTime: (hour: Int, minute: Int) -> Unit,
) {
    var chooseHour by remember { mutableIntStateOf(startTime) }
    var chooseMinute by remember { mutableIntStateOf(startMinute) }

    DodamModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = titleText,
                color = TimePickerDefaults.TitleTextColor,
                style = TimePickerDefaults.TitleTextStyle,
            )
        },
        content = {
            Spacer(modifier = Modifier.height(12.dp))
            DodamTimePicker(
                startTime = startTime,
                startMinute = startMinute,
                onHourChanged = {
                    chooseHour = it
                },
                onMinChanged =  {
                    chooseMinute = it
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            DodamButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onSelectTime(chooseHour, chooseMinute)
                },
                text = buttonText,
                buttonSize = ButtonSize.Large,
                buttonRole = ButtonRole.Primary
            )
        }
    )
}

@Composable
internal fun DodamTimePicker(
    modifier: Modifier = Modifier,
    startTime: Int = 1,
    startMinute: Int = 0,
    onHourChanged: (Int) -> Unit,
    onMinChanged: (Int) -> Unit
) {
    val hours = (1..23).toImmutableList()
    val minutes = (0..59).toImmutableList()

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .height(44.dp)
                .absoluteOffset(y = (-6).dp)
                .background(
                    color = TimePickerDefaults.IndicatorColor,
                    shape = TimePickerDefaults.IndicatorShape,
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = ":",
                color = TimePickerDefaults.ActiveTextColor,
                style = TimePickerDefaults.ActiveTextColumnTextStyle,
            )
        }
        Row(
            modifier = Modifier.align(Alignment.Center),
        ) {
            DodamWheelRangePicker(
                startIndex = startTime - 1,
                items = hours,
                size = DpSize(36.dp, 199.dp),
                onScrollFinished = {
                    onHourChanged(it % 24)
                    null
                },
            )
            Spacer(modifier = Modifier.width(55.dp))
            DodamWheelRangePicker(
                startIndex = startMinute,
                items = minutes,
                size = DpSize(36.dp, 199.dp),
                onScrollFinished = {
                    onMinChanged(it % 60)
                    null
                },
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun DodamWheelRangePicker(
    modifier: Modifier = Modifier,
    startIndex: Int,
    items: List<Int>,
    rowCount: Int = 5,
    size: DpSize = DpSize(128.dp, 128.dp),
    onScrollFinished: (snappedIndex: Int) -> Int? = { null },
) {
    val lazyListState = rememberLazyListState(startIndex)
    val isScrollInProgress = lazyListState.isScrollInProgress
    val flingBehavior = rememberSnapFlingBehavior(lazyListState)

    val centralItemIndex by remember {
        derivedStateOf { getCentralItemIndex(lazyListState)?.index ?: startIndex }
    }

    LaunchedEffect(isScrollInProgress) {
        if (!isScrollInProgress) {
            onScrollFinished(items[centralItemIndex % items.size])?.let {
                lazyListState.scrollToItem(it)
            }
        }
    }

    LazyColumn(
        state = lazyListState,
        flingBehavior = flingBehavior,
        modifier = modifier
            .height(size.height)
            .width(size.width),
        contentPadding = PaddingValues(vertical = size.height / rowCount * ((rowCount - 1) / 2)),
    ) {
        items(Int.MAX_VALUE) { index ->
            val active = (index == centralItemIndex)
            Text(
                modifier = Modifier
                    .height(size.height / rowCount)
                    .width(size.width),
                text = (items[index % items.size]).toTimeString(),
                color = if (active) TimePickerDefaults.ActiveTextColor else TimePickerDefaults.UnActiveTextColor,
                style = if (active) TimePickerDefaults.ActiveTextStyle else TimePickerDefaults.UnActiveTextStyle,
                textAlign = TextAlign.Center,
            )
        }
    }
}

object TimePickerDefaults {

    val ContainerColor @Composable get() = DodamTheme.colors.backgroundNormal

    val TitleTextStyle @Composable get() = DodamTheme.typography.heading2Bold()
    val TitleTextColor @Composable get() = DodamTheme.colors.labelStrong

    val UnActiveTextStyle @Composable get() = DodamTheme.typography.heading1Regular()
    val UnActiveTextColor @Composable get() = DodamTheme.colors.labelAlternative.copy(alpha = 0.5f)
    val ActiveTextStyle @Composable get() = DodamTheme.typography.title3Medium()
    val ActiveTextColor @Composable get() = DodamTheme.colors.labelNormal
    val ActiveTextColumnTextStyle @Composable get() = DodamTheme.typography.heading1Bold()

    val IndicatorColor @Composable get() = DodamTheme.colors.fillAlternative
    val IndicatorShape @Composable get() = DodamTheme.shapes.small

}

class DodamWheelItemInfo(
    private val lazyListItem: LazyListItemInfo,
) {
    val index: Int get() = lazyListItem.index
    val offset: Int get() = lazyListItem.offset
    val size: Int get() = lazyListItem.size
}

private val Center: (LazyListState, DodamWheelItemInfo) -> Int = { layout, item ->
    layout.startScrollOffset() + (layout.endScrollOffset() - layout.startScrollOffset() - item.size) / 2
}

val getCentralItemIndex: (LazyListState) -> DodamWheelItemInfo? = { layout ->
    layout.layoutInfo.visibleItemsInfo.asSequence().map(::DodamWheelItemInfo).lastOrNull { it.offset <= Center(layout, it) }
}

fun LazyListState.startScrollOffset() = 0

fun LazyListState.endScrollOffset() = this.layoutInfo.let { it.viewportEndOffset - it.afterContentPadding }

private fun Int.toTimeString(): String = this.toString().padStart(2, '0')

