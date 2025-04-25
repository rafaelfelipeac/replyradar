package com.rafaelfelipeac.replyradar.core.util

import androidx.compose.runtime.Composable
import kotlinx.datetime.LocalTime

@Composable
expect fun PlatformTimePicker(
    selectedTime: LocalTime?,
    onTimeSelected: (LocalTime) -> Unit
)
