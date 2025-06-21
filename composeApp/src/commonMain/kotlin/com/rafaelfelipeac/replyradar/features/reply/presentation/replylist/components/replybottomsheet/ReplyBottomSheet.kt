package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRoundedCorner
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnAddOrEditReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDeleteReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDismissBottomSheet
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnGoToSettings
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleArchive
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleResolve
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyBottomSheet(
    sheetState: SheetState,
    onIntent: (ReplyListScreenIntent) -> Unit,
    replyBottomSheetState: ReplyBottomSheetState,
    showPermissionDialog: Boolean,
    onShowPermissionDialog: (Boolean) -> Unit
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onIntent(OnDismissBottomSheet) },
        containerColor = colorScheme.background,
        dragHandle = null,
        shape = ReplyRoundedCorner(onlyTopCorners = true)
    ) {
        when (replyBottomSheetState.replyBottomSheetMode) {
            CREATE -> {
                BottomSheetContent(
                    state = ReplyBottomSheetState(CREATE),
                    onIntent = onIntent,
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
                        onIntent = onIntent,
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
    onIntent: (ReplyListScreenIntent) -> Unit,
    showPermissionDialog: Boolean,
    onShowPermissionDialog: (Boolean) -> Unit
) {
    ReplyBottomSheetContent(
        replyBottomSheetState = state,
        onResolve = { onIntent(OnToggleResolve(it)) },
        onArchive = { onIntent(OnToggleArchive(it)) },
        onDelete = { onIntent(OnDeleteReply(it)) },
        onComplete = { reply, notificationPermissionManager ->
            onIntent(OnAddOrEditReply(reply, notificationPermissionManager))
        },
        onGoToSettings = { notificationPermissionManager ->
            onIntent(OnGoToSettings(notificationPermissionManager))
        },
        showPermissionDialog = showPermissionDialog,
        onShowPermissionDialog = onShowPermissionDialog,
    )
}
