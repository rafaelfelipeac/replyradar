package com.rafaelfelipeac.replyradar.core.util.datetime

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

@Composable
expect fun PlatformDatePicker(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?,
    onDateSelected: (LocalDate) -> Unit,
    confirmButtonText: String,
    dismissButtonText: String,
    onTimeInvalidated: () -> Unit,
    onDismiss: () -> Unit
)
