package com.rafaelfelipeac.replyradar.core.util.datetime

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

@Composable
expect fun PlatformTimePicker(
    selectedTime: LocalTime?,
    selectedDate: LocalDate?,
    onTimeSelected: (LocalTime) -> Unit,
    onDismiss: () -> Unit,
    confirmButtonText: String,
    dismissButtonText: String,
    pickerTimeTitle: String
)
