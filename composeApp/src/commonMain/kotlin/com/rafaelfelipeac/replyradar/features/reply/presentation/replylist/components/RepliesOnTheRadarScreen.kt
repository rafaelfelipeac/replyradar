package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyProgress
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarError
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarPlaceholder
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnOpenReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyToggle
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListViewModel.Companion.ERROR_GET_REPLIES

@Composable
fun RepliesOnTheRadarScreen(state: ReplyListState, onIntent: (ReplyListScreenIntent) -> Unit) {
    if (state.isLoading) {
        ReplyProgress()
    } else {
        when {
            state.errorMessage != null -> {
                ReplyRadarError(errorMessage = getErrorMessage(state.errorMessage))
            }

            state.replies.isEmpty() -> {
                ReplyRadarPlaceholder(
                    message = LocalReplyRadarStrings.current.replyListPlaceholderOnTheRadar
                )
            }

            else -> {
                ReplyList(
                    modifier = Modifier
                        .fillMaxSize(),
                    replies = state.replies,
                    onReplyClick = { onIntent(OnOpenReply(it)) },
                    onReplyToggle = { onIntent(OnReplyToggle(it)) }
                )
            }
        }
    }
}

@Composable
private fun getErrorMessage(errorMessage: String?) = when (errorMessage) {
    ERROR_GET_REPLIES -> LocalReplyRadarStrings.current.replyListGetRepliesError
    else -> LocalReplyRadarStrings.current.genericErrorMessage
}
