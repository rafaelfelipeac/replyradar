package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRoundedCorner
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnAddReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDeleteReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDismissBottomSheet
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnEditReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleArchive
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleResolve
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyBottomSheet(
    onIntent: (ReplyListScreenIntent) -> Unit,
    replyBottomSheetState: ReplyBottomSheetState
) {
    ModalBottomSheet(
        onDismissRequest = { onIntent(OnDismissBottomSheet) },
        containerColor = colorScheme.background,
        dragHandle = null,
        shape = ReplyRoundedCorner(onlyTopCorners = true)
    ) {
        when (replyBottomSheetState.replyBottomSheetMode) {
            CREATE -> {
                BottomSheetContent(
                    state = ReplyBottomSheetState(CREATE),
                    onComplete = { onIntent(OnAddReply(it)) },
                    onIntent = onIntent
                )
            }

            EDIT -> {
                if (replyBottomSheetState.reply != null) {
                    BottomSheetContent(
                        state = ReplyBottomSheetState(
                            EDIT,
                            reply = replyBottomSheetState.reply
                        ),
                        onComplete = { onIntent(OnEditReply(it)) },
                        onIntent = onIntent
                    )
                }
            }
        }
    }
}

@Composable
private fun BottomSheetContent(
    state: ReplyBottomSheetState,
    onComplete: (Reply) -> Unit,
    onIntent: (ReplyListScreenIntent) -> Unit
) {
    ReplyBottomSheetContent(
        replyBottomSheetState = state,
        onComplete = onComplete,
        onResolve = { onIntent(OnToggleResolve(it)) },
        onArchive = { onIntent(OnToggleArchive(it)) },
        onDelete = { onIntent(OnDeleteReply(it)) }
    )
}
