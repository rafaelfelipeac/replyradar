package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRoundedCorner
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplySnackbar
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyBottomSheet(
    sheetState: SheetState,
    onSave: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit,
    onDismiss: () -> Unit,
    replyBottomSheetState: ReplyBottomSheetState
) {
    val snackbarHostState = remember { SnackbarHostState() }
    var invalidReminderValue by remember { mutableStateOf(false) }

    val localStrings = LocalReplyRadarStrings.current

    LaunchedEffect(invalidReminderValue) {
        if (invalidReminderValue) {
            snackbarHostState.showSnackbar(localStrings.replyListReminderInvalidDateTime)
            invalidReminderValue = false
        }
    }

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss,
        containerColor = colorScheme.background,
        dragHandle = null,
        shape = ReplyRoundedCorner(onlyTopCorners = true)
    ) {
        when (replyBottomSheetState.replyBottomSheetMode) {
            CREATE -> {
                BottomSheetContent(
                    state = ReplyBottomSheetState(CREATE),
                    onSave = onSave,
                    onResolve = onResolve,
                    onArchive = onArchive,
                    onDelete = onDelete,
                    onInvalidReminderValue = { invalidReminderValue = true }
                )
            }

            EDIT -> {
                if (replyBottomSheetState.reply != null) {
                    BottomSheetContent(
                        state = ReplyBottomSheetState(
                            EDIT,
                            reply = replyBottomSheetState.reply
                        ),
                        onSave = onSave,
                        onResolve = onResolve,
                        onArchive = onArchive,
                        onDelete = onDelete,
                        onInvalidReminderValue = { invalidReminderValue = true }
                    )
                }
            }
        }

        ReplySnackbar(snackbarHostState)
    }
}

@Composable
private fun BottomSheetContent(
    state: ReplyBottomSheetState,
    onSave: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit,
    onInvalidReminderValue: () -> Unit
) {
    ReplyBottomSheetContent(
        replyBottomSheetState = state,
        onResolve = onResolve,
        onArchive = onArchive,
        onDelete = onDelete,
        onSave = onSave,
        onInvalidReminderValue = onInvalidReminderValue
    )
}
