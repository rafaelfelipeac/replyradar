package com.rafaelfelipeac.replyradar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreen

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
        state = com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState(
            replies = replies
        ),
        onIntent = {}
    )
}