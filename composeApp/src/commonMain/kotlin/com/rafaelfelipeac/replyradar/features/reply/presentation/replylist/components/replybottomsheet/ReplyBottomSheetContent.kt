package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.rafaelfelipeac.replyradar.core.AppConstants.EMPTY
import com.rafaelfelipeac.replyradar.core.AppConstants.INITIAL_DATE_LONG
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_HOUR
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_DEFAULT_MINUTE
import com.rafaelfelipeac.replyradar.core.AppConstants.REMINDER_TOMORROW_OFFSET
import com.rafaelfelipeac.replyradar.core.common.clock.LocalClock
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyButton
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyConfirmationDialog
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyOutlinedButton
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextField
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextFieldSize.Large
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.util.format
import com.rafaelfelipeac.replyradar.core.util.formatTimestamp
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.reminder.Reminder
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT
import kotlinx.datetime.DateTimeUnit.Companion.DAY
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_archive
import replyradar.composeapp.generated.resources.ic_check
import replyradar.composeapp.generated.resources.ic_delete
import replyradar.composeapp.generated.resources.ic_reopen
import replyradar.composeapp.generated.resources.ic_unarchive

private const val WEIGHT = 1f

@Composable
fun ReplyBottomSheetContent(
    replyBottomSheetState: ReplyBottomSheetState? = null,
    onComplete: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    replyBottomSheetState?.let { state ->
        var name by remember { mutableStateOf(state.reply?.name ?: EMPTY) }
        var subject by remember { mutableStateOf(state.reply?.subject ?: EMPTY) }
        var selectedTime by remember { mutableStateOf<LocalTime?>(null) }
        var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.background)
                .padding(start = paddingMedium, top = paddingMedium, end = paddingMedium),
            horizontalAlignment = CenterHorizontally
        ) {
            val focusRequester = remember { FocusRequester() }
            val keyboardController = LocalSoftwareKeyboardController.current

            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
                keyboardController?.show()
            }

            ReplyTextField(
                modifier = Modifier
                    .padding(top = paddingSmall)
                    .focusRequester(focusRequester),
                value = name,
                placeholder = LocalReplyRadarStrings.current.replyListBottomSheetName,
                onValueChange = { name = it },
                textSize = Large
            )

            ReplyTextField(
                value = subject,
                placeholder = LocalReplyRadarStrings.current.replyListBottomSheetSubject,
                onValueChange = { subject = it }
            )

            state.reply?.let {
                Text(
                    modifier = Modifier
                        .padding(start = paddingSmall, top = paddingSmall)
                        .align(Start),
                    text = getTimestamp(state.reply),
                    style = typography.bodySmall
                )
            }

            Reminder(
                selectedTime = selectedTime,
                selectedDate = selectedDate,
                onSelectedTimeChange = { selectedTime = it },
                onSelectedDateChange = { selectedDate = it },
                closeKeyboard = { keyboardController?.hide() }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = paddingSmall, bottom = paddingMedium, end = paddingSmall),
                horizontalArrangement = if (isEditMode(state)) spacedBy(paddingSmall) else End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (state.reply != null && isEditMode(state)) {
                    Row(
                        modifier = Modifier
                            .weight(WEIGHT)
                    ) {
                        with(state.reply) {
                            when {
                                !isArchived && !isResolved -> {
                                    ActiveStateButtons(
                                        reply = state.reply,
                                        onArchive = onArchive,
                                        onResolve = onResolve
                                    )
                                }

                                isResolved && !isArchived -> {
                                    ResolvedStateButtons(
                                        reply = state.reply,
                                        onArchive = onArchive,
                                        onResolve = onResolve
                                    )
                                }

                                isArchived -> {
                                    ArchivedStateButton(
                                        reply = state.reply,
                                        onArchive = onArchive,
                                        onDelete = onDelete
                                    )
                                }
                            }
                        }
                    }
                }

                val reminderAt = getReminderTimestamp(
                    selectedDate = selectedDate,
                    selectedTime = selectedTime
                )

                ReplyButton(
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(Alignment.CenterVertically),
                    text = if (state.reply == null) {
                        LocalReplyRadarStrings.current.replyListBottomSheetAdd
                    } else {
                        LocalReplyRadarStrings.current.replyListBottomSheetSave
                    },
                    onClick = {
                        if (state.reply != null) {
                            onComplete(
                                state.reply.copy(
                                    name = name,
                                    subject = subject,
                                    reminderAt = reminderAt
                                )
                            )
                        } else {
                            onComplete(
                                Reply(
                                    name = name,
                                    subject = subject,
                                    reminderAt = reminderAt
                                )
                            )
                        }
                    },
                    enabled = name.isNotBlank()
                )
            }
        }
    }
}

private fun isEditMode(state: ReplyBottomSheetState) = state.replyBottomSheetMode == EDIT

@Composable
private fun ActiveStateButtons(
    reply: Reply,
    onArchive: (Reply) -> Unit,
    onResolve: (Reply) -> Unit
) {
    ReplyOutlinedButton(
        text = LocalReplyRadarStrings.current.replyListBottomSheetResolve,
        icon = drawable.ic_check,
        onClick = { onResolve(reply) }
    )

    ReplyOutlinedButton(
        text = LocalReplyRadarStrings.current.replyListBottomSheetArchive,
        icon = drawable.ic_archive,
        onClick = { onArchive(reply) }
    )
}

@Composable
private fun ResolvedStateButtons(
    reply: Reply,
    onArchive: (Reply) -> Unit,
    onResolve: (Reply) -> Unit
) {
    ReplyOutlinedButton(
        text = LocalReplyRadarStrings.current.replyListBottomSheetReopen,
        icon = drawable.ic_reopen,
        onClick = { onResolve(reply) }
    )

    ReplyOutlinedButton(
        text = LocalReplyRadarStrings.current.replyListBottomSheetArchive,
        icon = drawable.ic_archive,
        onClick = { onArchive(reply) }
    )
}

@Composable
private fun ArchivedStateButton(
    reply: Reply,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    ReplyOutlinedButton(
        text = LocalReplyRadarStrings.current.replyListBottomSheetUnarchive,
        icon = drawable.ic_unarchive,
        onClick = { onArchive(reply) }
    )

    ReplyOutlinedButton(
        text = LocalReplyRadarStrings.current.replyListBottomSheetDelete,
        icon = drawable.ic_delete,
        onClick = { showDeleteDialog = true }
    )

    if (showDeleteDialog) {
        ReplyConfirmationDialog(
            title = LocalReplyRadarStrings.current.replyListDeleteDialogTitle,
            description = format(
                LocalReplyRadarStrings.current.replyListDeleteDialogDescription,
                reply.name
            ),
            confirm = LocalReplyRadarStrings.current.replyListDeleteDialogConfirm,
            dismiss = LocalReplyRadarStrings.current.replyListDeleteDialogDismiss,
            onDismiss = { showDeleteDialog = false },
            onConfirm = { onDelete(reply) }
        )
    }
}

@Composable
private fun getTimestamp(reply: Reply): String {
    with(reply) {
        return when {
            archivedAt != INITIAL_DATE_LONG -> format(
                LocalReplyRadarStrings.current.replyListItemArchivedAt,
                formatTimestamp(archivedAt)
            )

            resolvedAt != INITIAL_DATE_LONG -> format(
                LocalReplyRadarStrings.current.replyListItemResolvedAt,
                formatTimestamp(resolvedAt)
            )

            else -> {
                if (updatedAt != INITIAL_DATE_LONG && updatedAt != createdAt) {
                    format(
                        LocalReplyRadarStrings.current.replyListItemUpdatedAt,
                        formatTimestamp(updatedAt)
                    )
                } else {
                    format(
                        LocalReplyRadarStrings.current.replyListItemCreatedAt,
                        formatTimestamp(createdAt)
                    )
                }
            }
        }
    }
}

@Composable
fun getReminderTimestamp(
    selectedDate: LocalDate?,
    selectedTime: LocalTime?
): Long {
    val timeZone = TimeZone.currentSystemDefault()
    val nowDateTime =
        Instant.fromEpochMilliseconds(LocalClock.current.now()).toLocalDateTime(timeZone)

    val finalDate = when {
        selectedDate != null -> selectedDate
        selectedTime != null -> {
            val timeToday = LocalDateTime(
                date = nowDateTime.date,
                time = selectedTime
            )

            if (timeToday > nowDateTime) {
                nowDateTime.date
            } else {
                nowDateTime.date.plus(
                    REMINDER_TOMORROW_OFFSET,
                    DAY
                )
            }
        }

        else -> return INITIAL_DATE_LONG
    }

    val finalTime = selectedTime ?: LocalTime(REMINDER_DEFAULT_HOUR, REMINDER_DEFAULT_MINUTE)

    val finalDateTime = LocalDateTime(finalDate, finalTime)

    return finalDateTime.toInstant(timeZone).toEpochMilliseconds()
}
