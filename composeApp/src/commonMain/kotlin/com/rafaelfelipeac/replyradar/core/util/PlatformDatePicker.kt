package com.rafaelfelipeac.replyradar.core.util

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalDate

@Composable
expect fun PlatformDatePicker(
    selectedDate: LocalDate?,
    onDateSelected: (LocalDate) -> Unit
)
