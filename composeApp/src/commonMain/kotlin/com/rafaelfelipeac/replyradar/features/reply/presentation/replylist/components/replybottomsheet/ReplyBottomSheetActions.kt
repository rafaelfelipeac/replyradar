package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.clock.LocalClock
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyButton
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyConfirmationDialog
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyOutlinedButton
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.datetime.dateTime
import com.rafaelfelipeac.replyradar.core.util.format
import com.rafaelfelipeac.replyradar.core.datetime.getReminderTimestamp
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_archive
import replyradar.composeapp.generated.resources.ic_check
import replyradar.composeapp.generated.resources.ic_delete
import replyradar.composeapp.generated.resources.ic_reopen
import replyradar.composeapp.generated.resources.ic_unarchive

private const val WEIGHT = 1f

@Composable
fun ReplyBottomSheetActions(
    state: ReplyBottomSheetState,
    onArchive: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onDelete: (Reply) -> Unit,
    onSave: (Reply) -> Unit,
    selectedDate: LocalDate?,
    selectedTime: LocalTime?,
    reply: Reply?,
    name: String,
    subject: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingSmall, bottom = paddingMedium, end = paddingSmall),
        horizontalArrangement = if (isEditMode(state)) spacedBy(paddingSmall) else End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StateButtons(
            state = state,
            onArchive = onArchive,
            onResolve = onResolve,
            onDelete = onDelete
        )

        val reminderAtTimestamp = getReminderTimestamp(
            dateTime = LocalClock.current.now().dateTime(),
            selectedDate = selectedDate,
            selectedTime = selectedTime
        )

        ReplyButton(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterVertically),
            text = if (reply == null) {
                LocalReplyRadarStrings.current.replyListBottomSheetAdd
            } else {
                LocalReplyRadarStrings.current.replyListBottomSheetSave
            },
            onClick = {
                onSave(
                    getReplyToSave(
                        stateReply = state.reply,
                        name = name,
                        subject = subject,
                        reminderAtTimestamp = reminderAtTimestamp
                    )
                )
            },
            enabled = name.isNotBlank()
        )
    }
}

@Composable
private fun RowScope.StateButtons(
    state: ReplyBottomSheetState,
    onArchive: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    if (state.reply != null && isEditMode(state)) {
        Row(
            modifier = Modifier.Companion
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
}

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

private fun isEditMode(state: ReplyBottomSheetState) = state.replyBottomSheetMode == EDIT

private fun getReplyToSave(
    stateReply: Reply?,
    name: String,
    subject: String,
    reminderAtTimestamp: Long
) = stateReply?.copy(
    name = name,
    subject = subject,
    reminderAt = reminderAtTimestamp
) ?: Reply(
    name = name,
    subject = subject,
    reminderAt = reminderAtTimestamp
)
