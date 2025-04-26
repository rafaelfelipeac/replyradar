package com.rafaelfelipeac.replyradar.core.util

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.reminder.isTimeValid
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun PlatformTimePicker(
    selectedTime: LocalTime?,
    selectedDate: LocalDate?,
    onTimeSelected: (LocalTime) -> Unit
) {
    val timePickerState = rememberTimePickerState(
        initialHour = selectedTime?.hour ?: 12,
        initialMinute = selectedTime?.minute ?: 0
    )

    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        val pickedTime = LocalTime(timePickerState.hour, timePickerState.minute)
        val isValid = isTimeValid(selectedDate, pickedTime)

        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (isValid) {
                            onTimeSelected(pickedTime)
                            showDialog = false
                        }
                    },
                    enabled = isValid
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            },
            title = { Text("Selecionar horário") },
            text = {
                TimePicker(state = timePickerState)
            }
        )
    }
}
