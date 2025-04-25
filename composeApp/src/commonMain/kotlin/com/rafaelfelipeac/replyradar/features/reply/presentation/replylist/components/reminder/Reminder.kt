package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.reminder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_HOUR
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_MINUTE
import com.rafaelfelipeac.replyradar.core.common.clock.LocalClock
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.iconButtonSize
import com.rafaelfelipeac.replyradar.core.common.ui.iconSize
import com.rafaelfelipeac.replyradar.core.common.ui.listDividerThickness
import com.rafaelfelipeac.replyradar.core.common.ui.paddingLarge
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.common.ui.theme.horizontalDividerColor
import com.rafaelfelipeac.replyradar.core.common.ui.theme.textFieldPlaceholderColor
import com.rafaelfelipeac.replyradar.core.common.ui.theme.toolbarIconsColor
import com.rafaelfelipeac.replyradar.core.util.PlatformDatePicker
import com.rafaelfelipeac.replyradar.core.util.PlatformTimePicker
import com.rafaelfelipeac.replyradar.core.util.toTwoDigitString
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.painterResource
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_close
import replyradar.composeapp.generated.resources.ic_date
import replyradar.composeapp.generated.resources.ic_time

@Composable
fun Reminder(
    selectedTime: LocalTime?,
    selectedDate: LocalDate?,
    onSelectedTimeChange: (LocalTime?) -> Unit,
    onSelectedDateChange: (LocalDate?) -> Unit,
    closeKeyboard: () -> Unit?
) {
    var showTimePicker by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    val reminderText = formatReminder(selectedDate = selectedDate, selectedTime = selectedTime)

    ReminderText(
        reminderText = reminderText,
        onDeleteClick = {
            onSelectedTimeChange(null)
            onSelectedDateChange(null)
            showTimePicker = false
            showDatePicker = false
        }
    )

    HorizontalDivider(
        modifier = Modifier
            .padding(top = paddingSmall, start = paddingXSmall, end = paddingXSmall),
        thickness = listDividerThickness,
        color = colorScheme.horizontalDividerColor
    )

//    if (showTimePicker || showDatePicker) {
//        Text(
//            text = LocalReplyRadarStrings.current.replyListReminder,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = paddingSmall, top = paddingSmall),
//            style = typography.bodyMedium,
//            color = colorScheme.textFieldPlaceholderColor
//        )
//    }

    if (showTimePicker) {
//        ReplyTimeSelector(
//            modifier = Modifier
//                .padding(top = paddingSmall),
//            selectedTime = selectedTime,
//            onTimeSelected = { onSelectedTimeChange(it) }
//        )

        PlatformTimePicker(
            selectedTime = selectedTime,
            onTimeSelected = { onSelectedTimeChange(it) }
        )
    }

    if (showDatePicker) {
//        ReplyDateSelector(
//            modifier = Modifier
//                .padding(top = paddingSmall),
//            selectedDate = selectedDate,
//            onDateSelected = { onSelectedDateChange(it) }
//        )

        PlatformDatePicker(
            selectedDate = selectedDate,
            onDateSelected = { onSelectedDateChange(it) }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingSmall),
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(
            onClick = {
                showTimePicker = !showTimePicker
                closeKeyboard()
            },
            modifier = Modifier
                .size(iconButtonSize)
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = painterResource(drawable.ic_time),
                contentDescription = LocalReplyRadarStrings.current.replyListReminderTimeIconContentDescription,
                tint =  colorScheme.primary //if (showTimePicker) colorScheme.primary else colorScheme.replyBottomSheetIconColor
            )
        }

        IconButton(
            onClick = {
                showDatePicker = !showDatePicker
                closeKeyboard()
            },
            modifier = Modifier
                .size(iconButtonSize)
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = painterResource(drawable.ic_date),
                contentDescription = LocalReplyRadarStrings.current.replyListReminderDateIconContentDescription,
                tint =  colorScheme.primary //if (showDatePicker) colorScheme.primary else colorScheme.replyBottomSheetIconColor
            )
        }
    }

    HorizontalDivider(
        modifier = Modifier
            .padding(vertical = paddingSmall, horizontal = paddingXSmall),
        thickness = listDividerThickness,
        color = colorScheme.horizontalDividerColor
    )
}

@Composable
private fun ReminderText(
    reminderText: String?,
    onDeleteClick: () -> Unit
) {
    if (reminderText != null) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = reminderText,
                modifier = Modifier
                    .padding(start = paddingSmall, top = paddingSmall),
                style = typography.bodyMedium,
                color = colorScheme.textFieldPlaceholderColor
            )

            IconButton(
                modifier = Modifier
                    .padding(start = paddingLarge)
                    .size(iconButtonSize),
                onClick = { onDeleteClick() },
            ) {
                Icon(
                    modifier = Modifier
                        .size(iconSize),
                    painter = painterResource(drawable.ic_close),
                    contentDescription = LocalReplyRadarStrings.current.replyListReminderCloseIconContentDescription,
                    tint = colorScheme.toolbarIconsColor
                )
            }
        }
    }
}

@Composable
fun formatReminder(selectedDate: LocalDate?, selectedTime: LocalTime?): String? {
    if (selectedDate == null && selectedTime == null) return null

    val timeZone = TimeZone.currentSystemDefault()
    val now = Instant.fromEpochMilliseconds(LocalClock.current.now()).toLocalDateTime(timeZone)
    val defaultTime = LocalTime(REMINDER_DEFAULT_HOUR, REMINDER_DEFAULT_MINUTE)

    val datePart = when {
        selectedDate != null -> {
            val day = selectedDate.dayOfMonth.toTwoDigitString()
            val month = selectedDate.monthNumber.toTwoDigitString()
            val year = selectedDate.year.toString()
            "$day/$month/$year"
        }

        selectedTime != null -> {
            val reminderTimeToday = LocalDateTime(now.date, selectedTime)
            if (reminderTimeToday > now) {
                LocalReplyRadarStrings.current.replyListReminderToday
            } else {
                LocalReplyRadarStrings.current.replyListReminderTomorrow
            }
        }

        else -> null
    }

    val timePart = when {
        selectedTime != null -> "${selectedTime.hour.toTwoDigitString()}:${selectedTime.minute.toTwoDigitString()}"
        selectedDate != null -> "${defaultTime.hour.toTwoDigitString()}:${defaultTime.minute.toTwoDigitString()}"
        else -> null
    }


    return "${LocalReplyRadarStrings.current.replyListReminderSet} ${
        when {
            datePart != null && timePart != null -> "$datePart $timePart"
            datePart != null -> datePart
            else -> timePart
        }
    }"
}
