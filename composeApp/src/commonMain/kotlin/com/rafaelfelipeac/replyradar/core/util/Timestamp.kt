package com.rafaelfelipeac.replyradar.core.util

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun formatTimestamp(timestampMillis: Long): String {
    val instant = Instant.fromEpochMilliseconds(timestampMillis)
    val localDateTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())

    return "${localDateTime.dayOfMonth}/${localDateTime.monthNumber}/${localDateTime.year} " +
            "${localDateTime.hour}:${localDateTime.minute.toString().padStart(LENGTH, PAD_CHAR)}"
}

private const val LENGTH = 2
private const val PAD_CHAR = '0'
