package com.rafaelfelipeac.replyradar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.reply.domain.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.reply_list.ReplyListScreen
import com.rafaelfelipeac.replyradar.reply.presentation.reply_list.ReplyListState

private val replies = (1..100).map {
    Reply(
        id = it.toString(),
        title = "Reply $it",
        description = "Description $it"
    )
}

@Preview
@Composable
private fun ReplyListScreenPreview() {
    ReplyListScreen(
        state = ReplyListState(
            results = replies
        ),
        onAction = {}
    )
}