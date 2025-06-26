package com.rafaelfelipeac.replyradar.core.util.datetime

import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_HOUR
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_MINUTE
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

const val LOCAL_TIME_HOUR_DEFAULT = 24
const val LOCAL_TIME_MINUTE_DEFAULT = 0
const val HOUR_OFFSET = 1
const val HOUR_OFFSET_DEFAULT = 0
const val MINUTE_EMPTY = 0

fun Long.dateTime(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDateTime {
    return Instant.fromEpochMilliseconds(this)
        .toLocalDateTime(timeZone)
}

fun isDateTimeValid(date: LocalDate?, time: LocalTime, dateTime: LocalDateTime): Boolean {
    return when {
        date == null -> {
            val todayTime = LocalDateTime(dateTime.date, time)

            todayTime > dateTime
        }

        date == dateTime.date -> {
            val selectedDateTime = LocalDateTime(date, time)

            selectedDateTime > dateTime
        }

        date > dateTime.date -> true
        else -> false
    }
}

fun getDefaultTime(
    dateTime: LocalDateTime,
    selectedDate: LocalDate?,
    selectedTime: LocalTime?
): LocalTime {
    if (selectedTime != null && isDateTimeValid(
            date = selectedDate,
            time = selectedTime,
            dateTime = dateTime
        )
    ) {
        return selectedTime
    }

    val defaultTime = LocalTime(REMINDER_DEFAULT_HOUR, REMINDER_DEFAULT_MINUTE)

    if (isDateTimeValid(date = selectedDate, time = defaultTime, dateTime = dateTime)) {
        return defaultTime
    }

    val nextHour =
        dateTime.hour + if (dateTime.minute > MINUTE_EMPTY) HOUR_OFFSET else HOUR_OFFSET_DEFAULT

    return LocalTime(hour = nextHour % LOCAL_TIME_HOUR_DEFAULT, minute = LOCAL_TIME_MINUTE_DEFAULT)
}

fun isTimeValid(dateTime: LocalDateTime, date: LocalDate?, time: LocalTime): Boolean {
    return when {
        date == null -> {
            val todayTime = LocalDateTime(dateTime.date, time)
            todayTime > dateTime
        }

        date == dateTime.date -> {
            val selectedDateTime = LocalDateTime(date, time)
            selectedDateTime > dateTime
        }

        date > dateTime.date -> true
        else -> false
    }
}
