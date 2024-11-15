package com.b1nd.dodam.designsystem.component

import androidx.compose.material3.CalendarLocale
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ptr
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime
import kotlinx.datetime.isoDayNumber
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toKotlinInstant
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.until
import platform.Foundation.NSCalendar
import platform.Foundation.NSDate
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale
import platform.Foundation.now
import platform.darwin.OS_LOG_DEFAULT
import platform.darwin.OS_LOG_TYPE_INFO
import platform.darwin.__dso_handle
import platform.darwin._os_log_internal


internal class CalendarModelImpl(
    private val locale: CalendarLocale
): CalendarModel() {

    private val _calendar: NSCalendar
        get() {
            val calendar = NSCalendar.currentCalendar
            calendar.setLocale(locale)
            return calendar
        }

    private val _today
        get() = NSDate.now()

    private val localTimeZone
        get() = TimeZone.currentSystemDefault()

    override val date: CalendarDate
        get() {
            val datetime = _today.toKotlinInstant().toLocalDateTime(TimeZone.currentSystemDefault())
            return datetime.toCalendarDate()
        }

    override val firstDayOfWeek: Int
        get() = _calendar.firstWeekday.toInt()

    override val today: Int
        get() = _today.toKotlinInstant().toLocalDateTime(TimeZone.currentSystemDefault()).dayOfMonth

    override val weekdayNames: ImmutableList<String> =
        _calendar.veryShortWeekdaySymbols()
            .map { it.toString() }
            .toImmutableList()

    override fun getMonth(year: Int, month: Int): CalendarMonth {
        return getMonth(LocalDateTime(year, month, 1, 0, 0))
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun getMonth(firstDayLocalDate: LocalDateTime): CalendarMonth {
        val difference = firstDayLocalDate.dayOfWeek.isoDayNumber - firstDayOfWeek
        val daysFromStartOfWeekToFirstOfMonth =
            if (difference < 0) {
                difference + DAYS_IN_WEEK
            } else {
                difference
            }
        _os_log_internal(__dso_handle.ptr, OS_LOG_DEFAULT, OS_LOG_TYPE_INFO, "DEBUG: ${firstDayLocalDate.date.numberOfDays()} $daysFromStartOfWeekToFirstOfMonth")
        return CalendarMonth(
            year = firstDayLocalDate.year,
            month = firstDayLocalDate.monthNumber,
            numberOfDays = firstDayLocalDate.date.numberOfDays(),
            daysFromStartOfWeekToFirstOfMonth = (daysFromStartOfWeekToFirstOfMonth + 1 ) % 7
        )
    }

    override fun getCanonicalDate(timeInMillis: Long): CalendarDate {
        return Instant.fromEpochMilliseconds(timeInMillis)
            .toLocalDateTime(localTimeZone)
            .toCalendarDate()
    }

    override fun prevMonth(calendarMonth: CalendarMonth): CalendarMonth {
        if (calendarMonth.month == 1) {
            return getMonth(calendarMonth.year - 1, 12)
        }
        return getMonth(calendarMonth.year, calendarMonth.month - 1)
    }

    override fun nextMonth(calendarMonth: CalendarMonth): CalendarMonth {
        if (calendarMonth.month == 12) {
            return getMonth(calendarMonth.year + 1, 1)
        }
        return getMonth(calendarMonth.year, calendarMonth.month + 1)
    }

    override fun getUtcTimeMillis(year: Int, month: Int, dayOfMonth: Int): Long {
        return LocalDate(year, month, dayOfMonth)
            .atTime(LocalTime(0, 0))
            .toInstant(localTimeZone)
            .toEpochMilliseconds()
    }

    private fun LocalDate.numberOfDays(): Int {
        val start = LocalDate(year, month, 1)
        val end = start.plus(1, DateTimeUnit.MONTH)
        return start.until(end, DateTimeUnit.DAY)
    }

    private fun LocalDateTime.toCalendarDate(): CalendarDate {
        return CalendarDate(
            year = this.year,
            month = this.monthNumber,
            dayOfMonth = this.dayOfMonth,
            utcTimeMillis = this.date
                .atTime(LocalTime(0, 0))
                .toInstant(localTimeZone)
                .toEpochMilliseconds()
        )
    }

}

@ReadOnlyComposable
@Composable
internal actual fun defaultLocale(): com.b1nd.dodam.designsystem.component.CalendarLocale {
    return NSLocale.currentLocale
}

internal actual fun createCalendarModel(locale: com.b1nd.dodam.designsystem.component.CalendarLocale): CalendarModel {
    return CalendarModelImpl(locale)
}

actual typealias CalendarLocale = NSLocale