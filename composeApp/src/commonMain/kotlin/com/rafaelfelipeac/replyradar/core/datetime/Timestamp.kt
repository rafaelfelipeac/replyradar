package com.rafaelfelipeac.replyradar.core.datetime

import com.rafaelfelipeac.replyradar.core.util.AppConstants.INITIAL_DATE
import com.rafaelfelipeac.replyradar.core.util.AppConstants.REMINDER_DEFAULT_HOUR
import com.rafaelfelipeac.replyradar.core.util.AppConstants.REMINDER_DEFAULT_MINUTE
import com.rafaelfelipeac.replyradar.core.util.AppConstants.REMINDER_TOMORROW_OFFSET
import com.rafaelfelipeac.replyradar.core.util.toTwoDigitString
import kotlinx.datetime.DateTimeUnit.Companion.DAY
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant

fun formatTimestamp(timestampMillis: Long): String {
    val localDateTime = timestampMillis.dateTime()

    return "${localDateTime.dayOfMonth}/${localDateTime.monthNumber}/${localDateTime.year} " +
            "${localDateTime.hour}:${localDateTime.minute.toTwoDigitString()}"
}

fun getReminderTimestamp(
    dateTime: LocalDateTime,
    selectedDate: LocalDate?,
    selectedTime: LocalTime?
): Long {
    val timeZone = TimeZone.currentSystemDefault()

    val finalDate = when {
        selectedDate != null -> selectedDate
        selectedTime != null -> {
            val timeToday = LocalDateTime(
                date = dateTime.date,
                time = selectedTime
            )

            if (timeToday > dateTime) {
                dateTime.date
            } else {
                dateTime.date.plus(
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
