package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import com.rafaelfelipeac.replyradar.platform.ui.DesertWhite
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnAddReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDeleteReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDismissBottomSheet
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleResolve
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyBottomSheet(
    onIntent: (ReplyListScreenIntent) -> Unit,
    replyBottomSheetState: ReplyBottomSheetState
) {
    ModalBottomSheet(
        onDismissRequest = { onIntent(OnDismissBottomSheet) },
        containerColor = DesertWhite
    ) {
        when (replyBottomSheetState.replyBottomSheetMode) {
            CREATE -> {
                ReplyBottomSheetContent(
                    replyBottomSheetState = ReplyBottomSheetState(CREATE),
                    onComplete = { onIntent(OnAddReply(it)) },
                    onResolve = { onIntent(OnToggleResolve(it)) },
                    onDelete = { onIntent(OnDeleteReply(it)) }
                )
            }

            EDIT -> {
                if (replyBottomSheetState.reply != null) {
                    ReplyBottomSheetContent(
                        replyBottomSheetState = ReplyBottomSheetState(
                            EDIT,
                            reply = replyBottomSheetState.reply
                        ),
                        onComplete = { onIntent(OnAddReply(it)) },
                        onResolve = { onIntent(OnToggleResolve(it)) },
                        onDelete = { onIntent(OnDeleteReply(it)) }
                    )
                }
            }
        }
    }
}
