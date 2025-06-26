package com.rafaelfelipeac.replyradar.core.util.datetime

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atStartOfDayIn
import kotlinx.datetime.toLocalDateTime

fun LocalDate.toEpochMillis(): Long {
    return this.atStartOfDayIn(TimeZone.currentSystemDefault()).toEpochMilliseconds()
}

fun Long.toLocalDate(timeZone: TimeZone = TimeZone.currentSystemDefault()): LocalDate {
    return Instant.fromEpochMilliseconds(this)
        .toLocalDateTime(timeZone)
        .date
}
