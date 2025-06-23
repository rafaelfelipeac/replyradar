package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRoundedCorner
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
    onGoToSettings: () -> Unit,
    onDismiss: () -> Unit,
    replyBottomSheetState: ReplyBottomSheetState,
    showPermissionDialog: Boolean,
    onShowPermissionDialog: (Boolean) -> Unit
) {
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
                    onGoToSettings = onGoToSettings,
                    showPermissionDialog = showPermissionDialog,
                    onShowPermissionDialog = onShowPermissionDialog
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
                        onGoToSettings = onGoToSettings,
                        showPermissionDialog = showPermissionDialog,
                        onShowPermissionDialog = onShowPermissionDialog,
                    )
                }
            }
        }
    }
}

@Composable
private fun BottomSheetContent(
    state: ReplyBottomSheetState,
    onSave: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit,
    onGoToSettings: () -> Unit,
    showPermissionDialog: Boolean,
    onShowPermissionDialog: (Boolean) -> Unit
) {
    ReplyBottomSheetContent(
        replyBottomSheetState = state,
        onResolve = onResolve,
        onArchive = onArchive,
        onDelete = onDelete,
        onSave = onSave,
        onGoToSettings = onGoToSettings,
        showPermissionDialog = showPermissionDialog,
        onShowPermissionDialog = onShowPermissionDialog,
    )
}
