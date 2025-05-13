package com.rafaelfelipeac.replyradar.core.util

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

@Composable
expect fun PlatformDatePicker(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?,
    onDateSelected: (LocalDate) -> Unit,
    onTimeInvalidated: () -> Unit,
    onDismiss: () -> Unit,
    confirmButtonText: String,
    dismissButtonText: String
)
