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

/**
 * Calculates a reminder timestamp based on the current date-time and optional selections.
 *
 * Logic:
 * - If selectedDate is provided, use it as the final date
 * - If only selectedTime is provided, use today if the time is in the future, otherwise tomorrow
 * - If neither is provided, return INITIAL_DATE constant
 * - Final time defaults to REMINDER_DEFAULT_HOUR:REMINDER_DEFAULT_MINUTE if not provided
 *
 * @param dateTime Current date-time for comparison
 * @param selectedDate Optional specific date for the reminder
 * @param selectedTime Optional specific time for the reminder
 * @return Timestamp in milliseconds for the calculated reminder date-time
 */
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
