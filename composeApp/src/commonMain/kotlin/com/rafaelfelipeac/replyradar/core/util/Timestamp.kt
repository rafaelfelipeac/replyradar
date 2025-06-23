package com.rafaelfelipeac.replyradar.core.util

import com.rafaelfelipeac.replyradar.core.AppConstants.INITIAL_DATE
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_HOUR
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_MINUTE
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_TOMORROW_OFFSET
import kotlinx.datetime.DateTimeUnit.Companion.DAY
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

fun formatTimestamp(timestampMillis: Long): String {
    val instant = Instant.fromEpochMilliseconds(timestampMillis)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())

    return "${localDateTime.dayOfMonth}/${localDateTime.monthNumber}/${localDateTime.year} " +
        "${localDateTime.hour}:${localDateTime.minute.toTwoDigitString()}"
}

fun getReminderTimestamp(
    now: Long,
    selectedDate: LocalDate?,
    selectedTime: LocalTime?
): Long {
    val timeZone = TimeZone.currentSystemDefault()
    val nowDateTime =
        Instant.fromEpochMilliseconds(now).toLocalDateTime(timeZone)

    val finalDate = when {
        selectedDate != null -> selectedDate
        selectedTime != null -> {
            val timeToday = LocalDateTime(
                date = nowDateTime.date,
                time = selectedTime
            )

            if (timeToday > nowDateTime) {
                nowDateTime.date
            } else {
                nowDateTime.date.plus(
                    REMINDER_TOMORROW_OFFSET,
                    DAY
                )
            }
        }

        else -> return INITIAL_DATE
    }

    val finalTime = selectedTime ?: LocalTime(REMINDER_DEFAULT_HOUR, REMINDER_DEFAULT_MINUTE)

    val finalDateTime = LocalDateTime(finalDate, finalTime)

    return finalDateTime.toInstant(timeZone).toEpochMilliseconds()
}
