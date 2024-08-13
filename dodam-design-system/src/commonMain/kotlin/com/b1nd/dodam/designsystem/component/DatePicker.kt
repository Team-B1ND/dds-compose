package com.b1nd.dodam.designsystem.component

//import android.content.res.Configuration.UI_MODE_NIGHT_YES
//import android.util.Log
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.interaction.MutableInteractionSource
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxWithConstraints
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.ModalBottomSheet
//import androidx.compose.material3.SheetState
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.rememberModalBottomSheetState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.ReadOnlyComposable
//import androidx.compose.runtime.Stable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.saveable.Saver
//import androidx.compose.runtime.saveable.listSaver
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.drawBehind
//import androidx.compose.ui.geometry.CornerRadius
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.util.fastForEach
//import androidx.compose.ui.window.Dialog
//import com.b1nd.dodam.designsystem.DodamTheme
//import com.b1nd.dodam.designsystem.R
//import com.b1nd.dodam.designsystem.animation.rememberBounceIndication
//import com.b1nd.dodam.designsystem.component.DodamDatePickerDefaults.createCalendarModel
//import com.b1nd.dodam.designsystem.component.DodamDatePickerDefaults.defaultLocale
//import kotlinx.collections.immutable.ImmutableList
//import kotlinx.collections.immutable.toImmutableList
//import kotlinx.coroutines.launch
//import java.time.DayOfWeek
//import java.time.LocalDate
//import java.time.format.TextStyle
//import java.time.temporal.WeekFields
//import java.util.Locale
//
//@Composable
//fun DodamDatePickerDialog(
//    modifier: Modifier = Modifier,
//    state: DodamDatePickerState = rememberDodamDatePickerState(),
//    title: String = "외출 일시",
//    isFixedSize: Boolean = false,
//    isValidDate: (date: LocalDate) -> Boolean = { state.validDate(it) },
//    onDismissRequest: () -> Unit,
//    onClickPrevMonth: () -> Unit = { state.prevMonth() },
//    onClickNextMonth: () -> Unit = { state.nextMonth() },
//    onClickDate: (date: LocalDate, isValid: Boolean) -> Unit,
//    onClickSuccess: () -> Unit,
//) {
//    Dialog(
//        onDismissRequest = onDismissRequest,
//    ) {
//        Surface(
//            color = DodamDatePickerDefaults.ContainerColor,
//            shape = DodamTheme.shapes.extraLarge,
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(24.dp)
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(
//                    modifier = Modifier.align(Alignment.Start),
//                    text = title,
//                    style = DodamDatePickerDefaults.TitleTextStyle,
//                    color = DodamDatePickerDefaults.TitleTextColor
//                )
//                DodamDatePicker(
//                    modifier = modifier,
//                    state = state,
//                    isFixedSize = isFixedSize,
//                    isValidDate = isValidDate,
//                    onClickPrevMonth = onClickPrevMonth,
//                    onClickNextMonth = onClickNextMonth,
//                    onClickDate = onClickDate,
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                Row(
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    Spacer(modifier = Modifier.weight(1f))
//                    DodamTextButton(
//                        onClick = onClickSuccess,
//                        text = "선택",
//                        size = TextButtonSize.Large,
//                        type = TextButtonType.Primary
//                    )
//                }
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DodamDatePickerBottomSheet(
//    modifier: Modifier = Modifier,
//    sheetState: SheetState = rememberModalBottomSheetState(),
//    state: DodamDatePickerState = rememberDodamDatePickerState(),
//    title: String = "외출 일시",
//    isFixedSize: Boolean = false,
//    isValidDate: (date: LocalDate) -> Boolean = { state.validDate(it) },
//    onDismissRequest: () -> Unit,
//    onClickPrevMonth: () -> Unit = { state.prevMonth() },
//    onClickNextMonth: () -> Unit = { state.nextMonth() },
//    onClickDate: (date: LocalDate, isValid: Boolean) -> Unit,
//    onClickSuccess: () -> Unit,
//) {
//    DodamModalBottomSheet(
//        sheetState = sheetState,
//        onDismissRequest = onDismissRequest,
//        title = {
//            Text(
//                modifier = Modifier.align(Alignment.Start),
//                text = title,
//                style = DodamDatePickerDefaults.TitleTextStyle,
//                color = DodamDatePickerDefaults.TitleTextColor
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                DodamDatePicker(
//                    modifier = modifier,
//                    state = state,
//                    isFixedSize = isFixedSize,
//                    isValidDate = isValidDate,
//                    onClickPrevMonth = onClickPrevMonth,
//                    onClickNextMonth = onClickNextMonth,
//                    onClickDate = onClickDate,
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                DodamButton(
//                    modifier = Modifier.fillMaxWidth(),
//                    onClick = onClickSuccess,
//                    text = "선택",
//                    buttonRole = ButtonRole.Primary,
//                    buttonSize = ButtonSize.Large
//                )
//            }
//        }
//    )
//}
//
//@Composable
//fun DodamDatePicker(
//    modifier: Modifier = Modifier,
//    state: DodamDatePickerState = rememberDodamDatePickerState(),
//    isFixedSize: Boolean = false,
//    isValidDate: (date: LocalDate) -> Boolean = { state.validDate(it) },
//    onClickPrevMonth: () -> Unit = { state.prevMonth() },
//    onClickNextMonth: () -> Unit = { state.nextMonth() },
//    onClickDate: (date: LocalDate, isValid: Boolean) -> Unit,
//) {
//    Column(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(color = DodamDatePickerDefaults.ContainerColor),
//    ) {
//        DodamTimePickerHeader(
//            month = state.month,
//            onClickPrevMonth = onClickPrevMonth,
//            onClickNextMonth = onClickNextMonth,
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        DodamTimePickerMonth(
//            month = state.month,
//            selectDate = state.selectedDate,
//            weekdayNames = state.weekdayNames,
//            isFixedSize = isFixedSize,
//            isValidDate = isValidDate,
//            onClickDate = onClickDate,
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//    }
//}
//
//@Composable
//private fun DodamTimePickerHeader(month: CalendarMonth, onClickPrevMonth: () -> Unit, onClickNextMonth: () -> Unit) {
//    Row(
//        modifier = Modifier.fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//    ) {
//        Text(
//            text = "${month.year}년 ${month.month}월",
//            style = DodamDatePickerDefaults.DateTextStyle,
//            color = DodamDatePickerDefaults.DateTextColor,
//        )
//        Spacer(modifier = Modifier.weight(1f))
//        Box(
//            modifier = Modifier
//                .size(36.dp)
//                .clickable(
//                    onClick = onClickPrevMonth,
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = rememberBounceIndication()
//                ),
//            contentAlignment = Alignment.Center,
//        ) {
//            Image(
//                modifier = Modifier.size(20.dp),
//                painter = painterResource(id = R.drawable.ic_chevron_left),
//                colorFilter = ColorFilter.tint(DodamDatePickerDefaults.ImageButtonContentColor),
//                contentDescription = null
//            )
//        }
//        Spacer(modifier = Modifier.width(8.dp))
//        Box(
//            modifier = Modifier
//                .size(36.dp)
//                .clickable(
//                    onClick = onClickNextMonth,
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = rememberBounceIndication()
//                ),
//            contentAlignment = Alignment.Center,
//        ) {
//            Image(
//                modifier = Modifier.size(20.dp),
//                painter = painterResource(id = R.drawable.ic_chevron_right),
//                colorFilter = ColorFilter.tint(DodamDatePickerDefaults.ImageButtonContentColor),
//                contentDescription = null
//            )
//        }
//    }
//}
//
//@Composable
//private fun DodamTimePickerMonth(
//    month: CalendarMonth,
//    selectDate: LocalDate?,
//    weekdayNames: List<String>,
//    isValidDate: (date: LocalDate) -> Boolean,
//    isFixedSize: Boolean,
//    onClickDate: (date: LocalDate, isValid: Boolean) -> Unit,
//) {
//    BoxWithConstraints(
//        modifier = Modifier.fillMaxWidth(),
//    ) {
//        maxWidth
//        Column {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//            ) {
//                weekdayNames.fastForEach { weekdayName ->
//                    Text(
//                        modifier = Modifier.weight(1f),
//                        text = weekdayName,
//                        style = DodamDatePickerDefaults.WeeklyTextStyle,
//                        color = DodamDatePickerDefaults.WeeklyTextColor,
//                        textAlign = TextAlign.Center,
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.height(4.dp))
//            val maxCalendarRows = if (isFixedSize) {
//                MAX_CALENDAR_ROWS
//            } else {
//                when {
//                    (30 == month.numberOfDays && month.daysFromStartOfWeekToFirstOfMonth == 6) ||
//                            (31 == month.numberOfDays && (month.daysFromStartOfWeekToFirstOfMonth == 5 || month.daysFromStartOfWeekToFirstOfMonth == 6)) -> 6
//                    (28 == month.numberOfDays && month.daysFromStartOfWeekToFirstOfMonth == 0) -> 4
//                    else -> 5
//                }
//            }
//            for (weekIndex in 0 until maxCalendarRows) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height((34.33).dp),
//                    verticalAlignment = Alignment.CenterVertically,
//                ) {
//                    for (dayIndex in 0 until DAYS_IN_WEEK) {
//                        val cellIndex = weekIndex * DAYS_IN_WEEK + dayIndex
//                        if (
//                            cellIndex < month.daysFromStartOfWeekToFirstOfMonth ||
//                            cellIndex >=
//                            (month.daysFromStartOfWeekToFirstOfMonth + month.numberOfDays)
//                        ) {
//                            Spacer(
//                                modifier = Modifier.weight(1f),
//                            )
//                        } else {
//                            val dayNumber = cellIndex - month.daysFromStartOfWeekToFirstOfMonth + 1
//                            val isSelect = dayNumber == selectDate?.dayOfMonth &&
//                                    month.month == selectDate.monthValue &&
//                                    month.year == selectDate.year
//                            val date = LocalDate.of(month.year, month.month, dayNumber)
//                            val isValid = isValidDate(date)
//
//                            val selectContainerColor = DodamDatePickerDefaults.SelectDayContainerColor
//                            val testModifier = if (isSelect) Modifier.drawBehind {
//                                val boxWidth = size.width
//                                val indicatorSize = 38.dp.toPx()
//                                val offsetX = (boxWidth - indicatorSize) / 2
//                                drawRoundRect(
//                                    color = selectContainerColor,
//                                    cornerRadius = CornerRadius(DodamDatePickerDefaults.SelectDayShape.toPx()),
//                                    size = Size(indicatorSize, indicatorSize),
//                                    topLeft = Offset(
//                                        x = offsetX,
//                                        y = -(9).dp.toPx(),
//                                    ),
//                                )
//                            } else Modifier
//                            Box(
//                                modifier = Modifier
//                                    .weight(1f)
//                                    .clickable(
//                                        onClick = {
//                                            onClickDate(date, isValid)
//                                        },
//                                        interactionSource = remember { MutableInteractionSource() },
//                                        indication = rememberBounceIndication(
//                                            showBackground = false
//                                        )
//                                    )
//                                    .then(testModifier),
//                                contentAlignment = Alignment.Center,
//                            ) {
//                                Text(
//                                    modifier = Modifier,
//                                    text = dayNumber.toString(),
//                                    style = DodamDatePickerDefaults.DayTextStyle,
//                                    color = when {
//                                        isSelect -> DodamDatePickerDefaults.SelectDayTextColor
//                                        isValid -> DodamDatePickerDefaults.ActiveDayTextColor
//                                        else -> DodamDatePickerDefaults.UnActiveDayTextColor
//                                    },
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//object DodamDatePickerDefaults {
//
//    @Stable
//    fun createCalendarModel(locale: Locale): CalendarModel = CalendarModelImpl(locale)
//
//    @Composable
//    @ReadOnlyComposable
//    fun defaultLocale(): Locale {
//        return LocalConfiguration.current.locales[0]
//    }
//
//    val ContainerColor @Composable get() = DodamTheme.colors.backgroundNormal
//
//    val TitleTextStyle @Composable get() = DodamTheme.typography.heading2Bold
//    val TitleTextColor @Composable get() = DodamTheme.colors.labelStrong
//
//    val ImageButtonContentColor @Composable get() = DodamTheme.colors.primaryNormal
//
//    val DateTextStyle @Composable get() = DodamTheme.typography.body1Medium
//    val DateTextColor @Composable get() = DodamTheme.colors.labelStrong
//
//    val WeeklyTextStyle @Composable get() = DodamTheme.typography.labelRegular
//    val WeeklyTextColor @Composable get() = DodamTheme.colors.labelAlternative
//
//    val DayTextStyle @Composable get() = DodamTheme.typography.headlineMedium
//    val ActiveDayTextColor @Composable get() = DodamTheme.colors.labelAlternative
//    val UnActiveDayTextColor @Composable get() = DodamTheme.colors.labelAlternative.copy(alpha = 0.5f)
//    val SelectDayTextColor @Composable get() = DodamTheme.colors.staticWhite
//    val SelectDayContainerColor @Composable get() = DodamTheme.colors.primaryNormal
//    val SelectDayShape get() = 10.dp
//}
//
//abstract class CalendarModel {
//
//    abstract val today: Int
//
//    abstract val absoluteToday: Int
//
//    abstract val date: LocalDate
//
//    abstract val firstDayOfWeek: Int
//
//    abstract val weekdayNames: ImmutableList<String>
//
//    @Stable
//    abstract fun getMonth(year: Int, month: Int): CalendarMonth
//
//    @Stable
//    abstract fun prevMonth(calendarMonth: CalendarMonth): CalendarMonth
//
//    @Stable
//    abstract fun nextMonth(calendarMonth: CalendarMonth): CalendarMonth
//}
//
//internal class CalendarModelImpl(private val locale: Locale) : CalendarModel() {
//
//    private val _today
//        get() = LocalDate.now()
//
//    override val today: Int
//        get() = _today.dayOfMonth
//
//    override val absoluteToday: Int
//        get() {
//            return _today.dayOfMonth * _today.monthValue * 30 * _today.year
//        }
//
//    override val date: LocalDate
//        get() = _today
//
//    override val firstDayOfWeek: Int = WeekFields.of(locale).firstDayOfWeek.value
//
//    override val weekdayNames: ImmutableList<String> =
//        DayOfWeek.entries.map {
//            it.getDisplayName(TextStyle.NARROW, locale)
//        }.toMutableList().apply {
//            // set sunday to First Day
//            add(0, removeLast())
//        }.toImmutableList()
//
//    override fun getMonth(year: Int, month: Int): CalendarMonth {
//        return getMonth(LocalDate.of(year, month, 1))
//    }
//
//    override fun prevMonth(calendarMonth: CalendarMonth): CalendarMonth {
//        if (calendarMonth.month == 1) {
//            return getMonth(calendarMonth.year - 1, 12)
//        }
//        return getMonth(calendarMonth.year, calendarMonth.month - 1)
//    }
//
//    override fun nextMonth(calendarMonth: CalendarMonth): CalendarMonth {
//        if (calendarMonth.month == 12) {
//            return getMonth(calendarMonth.year + 1, 1)
//        }
//        return getMonth(calendarMonth.year, calendarMonth.month + 1)
//    }
//
//    private fun getMonth(firstDayLocalDate: LocalDate): CalendarMonth {
//        val difference = firstDayLocalDate.dayOfWeek.value - firstDayOfWeek
//        val daysFromStartOfWeekToFirstOfMonth =
//            if (difference < 0) {
//                difference + DAYS_IN_WEEK
//            } else {
//                difference
//            }
//        return CalendarMonth(
//            year = firstDayLocalDate.year,
//            month = firstDayLocalDate.monthValue,
//            numberOfDays = firstDayLocalDate.lengthOfMonth(),
//            daysFromStartOfWeekToFirstOfMonth = daysFromStartOfWeekToFirstOfMonth,
//        )
//    }
//}
//
//@Stable
//data class CalendarMonth(
//    val year: Int,
//    val month: Int,
//    val numberOfDays: Int,
//    val daysFromStartOfWeekToFirstOfMonth: Int,
//) {
//    fun isValidDate(date: LocalDate, calendarModel: CalendarModel): Boolean = calendarModel.date <= date
//}
//
//interface DodamDatePickerState {
//
//    var selectedDate: LocalDate
//
//    val weekdayNames: ImmutableList<String>
//
//    var month: CalendarMonth
//
//    fun prevMonth()
//
//    fun nextMonth()
//
//    fun validDate(date: LocalDate): Boolean
//}
//
//class DodamDatePickerStateImpl(
//    selectDate: LocalDate,
//    locale: Locale,
//    year: Int,
//    month: Int,
//) : DodamDatePickerState {
//
//    private val calendarModel = createCalendarModel(locale)
//
//    override val weekdayNames: ImmutableList<String>
//        get() = calendarModel.weekdayNames.toImmutableList()
//
//    override var month: CalendarMonth by mutableStateOf(calendarModel.getMonth(year, month))
//
//    override fun prevMonth() {
//        month = calendarModel.prevMonth(month)
//    }
//
//    override fun nextMonth() {
//        month = calendarModel.nextMonth(month)
//    }
//
//    override fun validDate(date: LocalDate): Boolean = month.isValidDate(date, calendarModel)
//
//    override var selectedDate: LocalDate by mutableStateOf(selectDate)
//
//    override fun toString(): String {
//        return "DodamDatePickerState(weekdayNames=${weekdayNames}, month=${month}, selectedDate=${selectedDate})"
//    }
//
//    companion object {
//        fun Saver(locale: Locale): Saver<DodamDatePickerStateImpl, Any> = listSaver(
//            save = {
//                listOf(
//                    it.selectedDate.toEpochDay(),
//                    it.month.year,
//                    it.month.month,
//                )
//            },
//            restore = {
//                DodamDatePickerStateImpl(
//                    selectDate = LocalDate.ofEpochDay(it[0] as Long),
//                    locale = locale,
//                    year = it[1] as Int,
//                    month = it[2] as Int,
//                )
//            },
//        )
//    }
//}
//
//@Composable
//fun rememberDodamDatePickerState(selectDate: LocalDate = LocalDate.now()): DodamDatePickerState {
//    val locale = defaultLocale()
//
//    return rememberSaveable(saver = DodamDatePickerStateImpl.Saver(locale)) {
//        DodamDatePickerStateImpl(
//            selectDate = selectDate,
//            locale = locale,
//            year = selectDate.year,
//            month = selectDate.monthValue,
//        )
//    }
//}
//
//private const val MAX_CALENDAR_ROWS = 6
//private const val DAYS_IN_WEEK = 7
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
//@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0xFF232424)
//private fun DodamDatePickerPreview() {
//    val datePickerState = rememberDodamDatePickerState()
//    val sheetState = rememberModalBottomSheetState()
//    val coroutineScope = rememberCoroutineScope()
//    var isShowDialog by remember { mutableStateOf(true) }
//    LaunchedEffect(key1 = true) {
//        sheetState.show()
//    }
//    DodamTheme {
//        if (isShowDialog) {
//            DodamDatePickerDialog(
//                state = datePickerState,
//                onDismissRequest = {
//                    isShowDialog = false
//                },
//                onClickDate = { date, isValid ->
//                    datePickerState.selectedDate = date
//                },
//                onClickSuccess = {
//                    isShowDialog = false
//                }
//            )
//        }
//        DodamDatePicker(
//            state = datePickerState,
//            onClickDate = { date, isValid ->
//                datePickerState.selectedDate = date
//            },
//        )
//
//        DodamDatePickerBottomSheet(
//            sheetState = sheetState,
//            state = datePickerState,
//            onDismissRequest = {
//                coroutineScope.launch {
//                    sheetState.hide()
//                }
//            },
//            onClickDate = { date, isValid ->
//                coroutineScope.launch {
//                    datePickerState.selectedDate = date
//                }
//            },
//            onClickSuccess = {}
//        )
//    }
//}