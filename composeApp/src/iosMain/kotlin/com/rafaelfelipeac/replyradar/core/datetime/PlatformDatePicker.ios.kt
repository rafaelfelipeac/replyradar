package com.rafaelfelipeac.replyradar.core.datetime

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

@Composable
actual fun PlatformDatePicker(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?,
    onDateSelected: (LocalDate) -> Unit,
    confirmButtonText: String,
    dismissButtonText: String,
    onTimeInvalidated: () -> Unit,
    onDismiss: () -> Unit
) {
    TODO("Not yet implemented for this platform.")
}
