package com.rafaelfelipeac.replyradar.core.util

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

@Composable
actual fun PlatformTimePicker(
    selectedTime: LocalTime?,
    selectedDate: LocalDate?,
    onTimeSelected: (LocalTime) -> Unit,
    onDismiss: () -> Unit,
    confirmButtonText: String,
    dismissButtonText: String,
    pickerTimeTitle: String
) {
    TODO("Not yet implemented for this platform.")
}
