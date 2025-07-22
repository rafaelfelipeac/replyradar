package com.rafaelfelipeac.replyradar.core.common.ui.components.util

import androidx.compose.runtime.Composable
import com.rafaelfelipeac.replyradar.core.datetime.getCurrentDateTime
import com.rafaelfelipeac.replyradar.core.datetime.getDefaultTime
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.util.format
import com.rafaelfelipeac.replyradar.core.util.toTwoDigitString
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

@Composable
fun formatReminderText(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?
): String? {
    if (selectedDate == null && selectedTime == null) return null

    val datetime = getCurrentDateTime()
    val defaultTime =
        getDefaultTime(datetime, selectedDate, selectedTime)

    val datePart = getDatePart(selectedDate, selectedTime, datetime)
    val timePart = getTimePart(selectedTime, selectedDate, defaultTime)

    return "${LocalReplyRadarStrings.current.replyListReminderSet} ${
        when {
            datePart != null && timePart != null -> format(LocalReplyRadarStrings.current.replyListReminderSetSeparator, datePart, timePart)
            datePart != null -> datePart
            else -> timePart
        }
    }"
}

@Composable
private fun getDatePart(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?,
    dateTime: LocalDateTime
) = when {
    selectedDate != null -> {
        val day = selectedDate.dayOfMonth.toTwoDigitString()
        val month = selectedDate.monthNumber.toTwoDigitString()
        val year = selectedDate.year.toString()
        "$day/$month/$year"
    }

    selectedTime != null -> {
        val reminderTimeToday = LocalDateTime(dateTime.date, selectedTime)
        if (reminderTimeToday > dateTime) {
            LocalReplyRadarStrings.current.replyListReminderToday
        } else {
            LocalReplyRadarStrings.current.replyListReminderTomorrow
        }
    }

    else -> null
}

private fun getTimePart(
    selectedTime: LocalTime?,
    selectedDate: LocalDate?,
    defaultTime: LocalTime
) = when {
    selectedTime != null -> "${selectedTime.hour.toTwoDigitString()}:${selectedTime.minute.toTwoDigitString()}"
    selectedDate != null -> "${defaultTime.hour.toTwoDigitString()}:${defaultTime.minute.toTwoDigitString()}"
    else -> null
}
