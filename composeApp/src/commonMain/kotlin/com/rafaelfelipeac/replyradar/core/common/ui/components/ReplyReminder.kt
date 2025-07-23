package com.rafaelfelipeac.replyradar.core.common.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.components.util.formatReminderText
import com.rafaelfelipeac.replyradar.core.common.ui.iconButtonSize
import com.rafaelfelipeac.replyradar.core.common.ui.iconSize
import com.rafaelfelipeac.replyradar.core.common.ui.listDividerThickness
import com.rafaelfelipeac.replyradar.core.common.ui.paddingLarge
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.theme.horizontalDividerColor
import com.rafaelfelipeac.replyradar.core.theme.toolbarIconsColor
import com.rafaelfelipeac.replyradar.core.datetime.PlatformDatePicker
import com.rafaelfelipeac.replyradar.core.datetime.PlatformTimePicker
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import org.jetbrains.compose.resources.painterResource
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_close
import replyradar.composeapp.generated.resources.ic_date
import replyradar.composeapp.generated.resources.ic_time

@Composable
fun ReplyReminder(
    selectedTime: LocalTime?,
    selectedDate: LocalDate?,
    onSelectedTimeChange: (LocalTime?) -> Unit,
    onSelectedDateChange: (LocalDate?) -> Unit,
    closeKeyboard: () -> Unit?
) {
    var showTimePicker by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    val reminderText = formatReminderText(
        selectedDate = selectedDate,
        selectedTime = selectedTime
    )

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

    if (showTimePicker) {
        PlatformTimePicker(
            selectedTime = selectedTime,
            selectedDate = selectedDate,
            confirmButtonText = LocalReplyRadarStrings.current.replyListReminderTimePickerConfirmButton,
            dismissButtonText = LocalReplyRadarStrings.current.replyListReminderTimePickerDismissButton,
            pickerTimeTitle = LocalReplyRadarStrings.current.replyListReminderTimePickerTitle,
            onTimeSelected = {
                onSelectedTimeChange(it)
                showTimePicker = false
            },
            onDismiss = {
                showTimePicker = false
            }
        )
    }

    if (showDatePicker) {
        PlatformDatePicker(
            selectedDate = selectedDate,
            selectedTime = selectedTime,
            confirmButtonText = LocalReplyRadarStrings.current.replyListReminderDatePickerConfirmButton,
            dismissButtonText = LocalReplyRadarStrings.current.replyListReminderDatePickerDismissButton,
            onDateSelected = {
                onSelectedDateChange(it)
                showDatePicker = false
            },
            onTimeInvalidated = {
                onSelectedTimeChange(null)
            },
            onDismiss = {
                showDatePicker = false
            }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingSmall),
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(
            modifier = Modifier
                .size(iconButtonSize),
            onClick = {
                showTimePicker = true
                closeKeyboard()
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = painterResource(drawable.ic_time),
                contentDescription = LocalReplyRadarStrings.current.replyListReminderTimeIconContentDescription,
                tint = colorScheme.primary
            )
        }

        IconButton(
            modifier = Modifier
                .size(iconButtonSize),
            onClick = {
                showDatePicker = true
                closeKeyboard()
            }
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = painterResource(drawable.ic_date),
                contentDescription = LocalReplyRadarStrings.current.replyListReminderDateIconContentDescription,
                tint = colorScheme.primary
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
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(start = paddingSmall, top = paddingSmall),
                text = reminderText,
                style = typography.bodySmall
            )

            IconButton(
                modifier = Modifier
                    .padding(start = paddingLarge, top = paddingSmall)
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
