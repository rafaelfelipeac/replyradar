package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.util.toTwoDigitString
import kotlinx.datetime.LocalTime

@Composable
fun ReplyTimeSelector(
    modifier: Modifier = Modifier,
    selectedTime: LocalTime?,
    onTimeSelected: (LocalTime) -> Unit
) {
    val hours = (0..23)
    val minutes = listOf(0, 15, 30, 45)

    val defaultHour = 12
    val defaultMinute = 0

    var expandedHour by remember { mutableStateOf(false) }
    var expandedMinute by remember { mutableStateOf(false) }
    var selectedHour by remember { mutableStateOf(selectedTime?.hour ?: defaultHour) }
    var selectedMinute by remember { mutableStateOf(selectedTime?.minute ?: defaultMinute) }

    if (selectedTime == null) {
        onTimeSelected(LocalTime(defaultHour, defaultMinute))
    }

    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = paddingSmall),
            text = LocalReplyRadarStrings.current.componentReplyTimeSelectorLabel,
            style = typography.bodySmall
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = paddingSmall)
        ) {
            Box {
                Text(
                    text = selectedHour.toTwoDigitString(),
                    style = typography.titleMedium,
                    color = colorScheme.primary,
                    modifier = Modifier
                        .clickable { expandedHour = true }
                )

                DropdownMenu(
                    expanded = expandedHour,
                    onDismissRequest = { expandedHour = false }
                ) {
                    hours.forEach { hour ->
                        DropdownMenuItem(
                            text = { Text(hour.toString()) },
                            onClick = {
                                selectedHour = hour
                                expandedHour = false
                                onTimeSelected(LocalTime(hour, selectedMinute))
                            }
                        )
                    }
                }
            }

            Text(
                text = TIME_SEPARATOR,
                style = typography.bodyLarge,
                modifier = Modifier
                    .alignByBaseline()
            )

            Box {
                Text(
                    text = selectedMinute.toTwoDigitString(),
                    style = typography.titleMedium,
                    color = colorScheme.primary,
                    modifier = Modifier
                        .clickable { expandedMinute = true }
                )

                DropdownMenu(
                    expanded = expandedMinute,
                    onDismissRequest = { expandedMinute = false }
                ) {
                    minutes.forEach { minute ->
                        DropdownMenuItem(
                            text = { Text(minute.toString()) },
                            onClick = {
                                selectedMinute = minute
                                expandedMinute = false
                                onTimeSelected(LocalTime(selectedHour, minute))
                            }
                        )
                    }
                }
            }
        }
    }
}

private const val TIME_SEPARATOR = ":"
