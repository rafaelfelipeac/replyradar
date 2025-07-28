package com.rafaelfelipeac.replyradar.core.datetime

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
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime

private const val HOUR_DEFAULT_INITIAL_HOUR = 12
private const val HOUR_DEFAULT_INITIAL_MINUTE = 12

@OptIn(ExperimentalMaterial3Api::class)
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
    val timePickerState = rememberTimePickerState(
        initialHour = selectedTime?.hour ?: HOUR_DEFAULT_INITIAL_HOUR,
        initialMinute = selectedTime?.minute ?: HOUR_DEFAULT_INITIAL_MINUTE
    )

    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        val pickedTime = LocalTime(timePickerState.hour, timePickerState.minute)
        val isValid = isDateTimeValid(
            dateTime = getCurrentDateTime(),
            date = selectedDate,
            time = pickedTime
        )

        AlertDialog(
            onDismissRequest = {
                onDismiss()
                showDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (isValid) {
                            onTimeSelected(pickedTime)
                            onDismiss()
                            showDialog = false
                        }
                    },
                    enabled = isValid
                ) {
                    Text(confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismiss()
                        showDialog = false
                    }
                ) {
                    Text(dismissButtonText)
                }
            },
            title = { Text(pickerTimeTitle) },
            text = {
                TimePicker(state = timePickerState)
            }
        )
    }
}
