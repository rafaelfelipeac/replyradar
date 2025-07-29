package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarPlaceholder
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnOpenReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState

@Composable
fun RepliesResolvedScreen(
    state: ReplyListState,
    onIntent: (ReplyListScreenIntent) -> Unit
) {
    if (state.resolvedReplies.isEmpty()) {
        ReplyRadarPlaceholder(message = LocalReplyRadarStrings.current.replyListPlaceholderResolved)
    } else {
        ReplyList(
            modifier = Modifier
                .fillMaxSize(),
            replies = state.resolvedReplies,
            onReplyClick = { onIntent(OnOpenReply(it)) }
        )
    }
}
