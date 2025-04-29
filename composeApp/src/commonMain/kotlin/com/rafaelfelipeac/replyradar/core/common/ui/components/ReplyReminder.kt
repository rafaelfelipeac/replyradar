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
import androidx.compose.ui.Modifier
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
import com.rafaelfelipeac.replyradar.core.util.datetime.formatReminder
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
    val reminderText = formatReminder(
        selectedDate = selectedDate,
        selectedTime = selectedTime,
        onTimeSelected = { onSelectedTimeChange(it) }
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
            onClick = {
                showTimePicker = true
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
                tint = colorScheme.primary
            )
        }

        IconButton(
            onClick = {
                showDatePicker = true
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
