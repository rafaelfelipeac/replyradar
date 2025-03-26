package com.rafaelfelipeac.replyradar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState

private val replies = (1L..10L).map {
    Reply(
        id = it,
        name = "Reply $it",
        subject = "Subject $it",
        isResolved = true
    )
}

@Preview
@Composable
private fun ReplyListScreenPreview() {
    ReplyListScreen(
        state = ReplyListState(
            replies = replies
        ),
        onIntent = {}
    )
}
