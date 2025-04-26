package com.rafaelfelipeac.replyradar.core.util

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
import com.rafaelfelipeac.replyradar.core.util.datetime.toEpochMillis
import com.rafaelfelipeac.replyradar.core.util.datetime.toLocalDate
import com.rafaelfelipeac.replyradar.core.util.datetime.isDateTimeValid
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.TimeZone.Companion.UTC
import kotlinx.datetime.toLocalDateTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
actual fun PlatformDatePicker(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?,
    onDateSelected: (LocalDate) -> Unit,
    onTimeInvalidated: () -> Unit
) {
    val now = Clock.System.now()
        .toLocalDateTime(TimeZone.currentSystemDefault())

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate?.toEpochMillis(),
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val candidateDate = Instant.fromEpochMilliseconds(utcTimeMillis)
                    .toLocalDateTime(UTC)
                    .date

                return candidateDate >= now.date
            }
        }
    )

    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val millis = datePickerState.selectedDateMillis
                        if (millis != null) {
                            val pickedDate = millis.toLocalDate()

                            onDateSelected(pickedDate)
                            selectedTime?.let {
                                val isStillValid = isDateTimeValid(
                                    date = pickedDate,
                                    time = it,
                                    now = now
                                )

                                if (!isStillValid) {
                                    onTimeInvalidated()
                                }
                            } ?: onTimeInvalidated()
                        }
                        showDialog = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showDialog = false }
                ) {
                    Text("Cancelar")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
