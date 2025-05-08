package com.rafaelfelipeac.replyradar.core.util.datetime

import androidx.compose.runtime.Composable
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_HOUR
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_MINUTE
import com.rafaelfelipeac.replyradar.core.common.clock.LocalClock
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.util.toTwoDigitString
import kotlinx.datetime.Clock
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

fun isDateTimeValid(date: LocalDate?, time: LocalTime, now: LocalDateTime): Boolean {
    return when {
        date == null -> {
            val todayTime = LocalDateTime(now.date, time)
            todayTime > now
        }

        date == now.date -> {
            val selectedDateTime = LocalDateTime(date, time)
            selectedDateTime > now
        }

        date > now.date -> true
        else -> false
    }
}

@Composable
fun getDefaultTime(selectedDate: LocalDate?, selectedTime: LocalTime?): LocalTime {
    val clock = LocalClock.current

    val now = Instant.fromEpochMilliseconds(clock.now())
        .toLocalDateTime(TimeZone.currentSystemDefault())

    val eightAM = LocalTime(REMINDER_DEFAULT_HOUR, REMINDER_DEFAULT_MINUTE)

    if (selectedTime != null && isDateTimeValid(
            date = selectedDate,
            time = selectedTime,
            now = now
        )
    ) {
        return selectedTime
    }

    if (isDateTimeValid(date = selectedDate, time = eightAM, now = now)) {
        return eightAM
    }

    val nextHour = now.hour + if (now.minute > MINUTE_EMPTY) HOUR_OFFSET else HOUR_OFFSET_DEFAULT

    return LocalTime(hour = nextHour % LOCAL_TIME_HOUR_DEFAULT, minute = LOCAL_TIME_MINUTE_DEFAULT)
}

@Composable
fun formatReminder(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?,
    onTimeSelected: (LocalTime) -> Unit,
): String? {
    if (selectedDate == null && selectedTime == null) return null

    val timeZone = TimeZone.currentSystemDefault()
    val now = Instant.fromEpochMilliseconds(LocalClock.current.now()).toLocalDateTime(timeZone)
    val defaultTime = getDefaultTime(selectedDate, selectedTime).also { onTimeSelected(it) }

    val datePart = when {
        selectedDate != null -> {
            val day = selectedDate.dayOfMonth.toTwoDigitString()
            val month = selectedDate.monthNumber.toTwoDigitString()
            val year = selectedDate.year.toString()
            "$day/$month/$year"
        }

        selectedTime != null -> {
            val reminderTimeToday = LocalDateTime(now.date, selectedTime)
            if (reminderTimeToday > now) {
                LocalReplyRadarStrings.current.replyListReminderToday
            } else {
                LocalReplyRadarStrings.current.replyListReminderTomorrow
            }
        }

        else -> null
    }

    val timePart = when {
        selectedTime != null -> "${selectedTime.hour.toTwoDigitString()}:${selectedTime.minute.toTwoDigitString()}"
        selectedDate != null -> "${defaultTime.hour.toTwoDigitString()}:${defaultTime.minute.toTwoDigitString()}"
        else -> null
    }


    return "${LocalReplyRadarStrings.current.replyListReminderSet} ${
        when {
            datePart != null && timePart != null -> "$datePart $timePart"
            datePart != null -> datePart
            else -> timePart
        }
    }"
}

fun isTimeValid(date: LocalDate?, time: LocalTime): Boolean {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    return when {
        date == null -> {
            val todayTime = LocalDateTime(now.date, time)
            todayTime > now
        }

        date == now.date -> {
            val selectedDateTime = LocalDateTime(date, time)
            selectedDateTime > now
        }

        date > now.date -> true
        else -> false
    }
}
