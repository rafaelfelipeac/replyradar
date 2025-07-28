package com.rafaelfelipeac.replyradar.core.datetime

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone.Companion.UTC

@OptIn(ExperimentalMaterial3Api::class)
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
    val dateTime = getCurrentDateTime()

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate?.toEpochMillis(),
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val candidateDate = utcTimeMillis.toLocalDate(UTC)

                return candidateDate >= dateTime.date
            }
        }
    )

    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = {
                onDismiss()
                showDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        val dateInMillis = datePickerState.selectedDateMillis

                        if (dateInMillis != null) {
                            val selectedDate = dateInMillis.toLocalDate(UTC)

                            onDateSelected(selectedDate)

                            selectedTime?.let { selectedTime ->
                                val isStillValid = isDateTimeValid(
                                    date = selectedDate,
                                    time = selectedTime,
                                    dateTime = dateTime
                                )

                                if (!isStillValid) {
                                    onTimeInvalidated()
                                }
                            } ?: onTimeInvalidated()
                        }

                        onDismiss()
                        showDialog = false
                    }
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
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
