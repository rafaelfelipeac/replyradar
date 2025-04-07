package com.rafaelfelipeac.replyradar.core.util

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun formatTimestamp(timestampMillis: Long): String {
    val instant = Instant.fromEpochMilliseconds(timestampMillis)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())

    return "${localDateTime.dayOfMonth}/${localDateTime.monthNumber}/${localDateTime.year} " +
        "${localDateTime.hour}:${localDateTime.minute.toString().padStart(2, '0')}"
}
