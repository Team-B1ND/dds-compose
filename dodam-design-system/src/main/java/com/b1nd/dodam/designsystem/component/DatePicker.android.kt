package com.b1nd.dodam.designsystem.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalConfiguration
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.TextStyle
import java.time.temporal.WeekFields
import java.util.Locale


internal class CalendarModelImpl(private val locale: CalendarLocale) : CalendarModel() {

    private val _today
        get(): CalendarDate {
            val date = LocalDate.now()

            return CalendarDate(
                year = date.year,
                month = date.monthValue,
                dayOfMonth = date.dayOfMonth,
                utcTimeMillis = date
                    .atTime(LocalTime.MIDNIGHT)
                    .atZone(utcTimeZoneId)
                    .toInstant()
                    .toEpochMilli()
                )
        }

    override val today: Int
        get() = _today.dayOfMonth

    override val date: CalendarDate
        get() = _today

    override val firstDayOfWeek: Int = WeekFields.of(locale).firstDayOfWeek.value

    override val weekdayNames: ImmutableList<String> =
        DayOfWeek.entries.map {
            it.getDisplayName(TextStyle.NARROW, locale)
        }.toMutableList().apply {
            // set sunday to First Day
            add(0, removeLast())
        }.toImmutableList()

    override fun getMonth(year: Int, month: Int): CalendarMonth {
        return getMonth(LocalDate.of(year, month, 1))
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

    override fun getCanonicalDate(timeInMillis: Long): CalendarDate {
        val localDate = Instant.ofEpochMilli(timeInMillis).atZone(utcTimeZoneId).toLocalDate()
        return CalendarDate(
            year = localDate.year,
            month = localDate.monthValue,
            dayOfMonth = localDate.dayOfMonth,
            utcTimeMillis = localDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000
        )
    }

    override fun getUtcTimeMillis(year: Int, month: Int, dayOfMonth: Int): Long {
        return LocalDate.of(year, month, dayOfMonth)
            .atTime(LocalTime.MIDNIGHT)
            .atZone(utcTimeZoneId)
            .toInstant()
            .toEpochMilli()
    }

    private fun getMonth(firstDayLocalDate: LocalDate): CalendarMonth {
        val difference = firstDayLocalDate.dayOfWeek.value - firstDayOfWeek
        val daysFromStartOfWeekToFirstOfMonth =
            if (difference < 0) {
                difference + DAYS_IN_WEEK
            } else {
                difference
            }
        return CalendarMonth(
            year = firstDayLocalDate.year,
            month = firstDayLocalDate.monthValue,
            numberOfDays = firstDayLocalDate.lengthOfMonth(),
            daysFromStartOfWeekToFirstOfMonth = daysFromStartOfWeekToFirstOfMonth,
        )
    }
}

internal val utcTimeZoneId: ZoneId = ZoneId.of("UTC")


actual typealias CalendarLocale = Locale

@Composable
@ReadOnlyComposable
internal actual fun defaultLocale(): CalendarLocale = Locale24.defaultLocale()


private class Locale24 {
    companion object {
        @Composable
        @ReadOnlyComposable
        fun defaultLocale(): CalendarLocale {
            return LocalConfiguration.current.locales[0]
        }
    }
}

internal actual fun createCalendarModel(locale: CalendarLocale): CalendarModel =
    CalendarModelImpl(locale)
