package com.rafaelfelipeac.replyradar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreen
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListState

private val replies = (1..10).map {
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
        onAction = {}
    )
}