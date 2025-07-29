package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.ReplyList

@Preview(showBackground = true)
@Composable
fun ReplyListPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyList(
            replies = listOf(
                Reply(
                    id = 1,
                    message = "Message 1",
                    isResolved = false
                ),
                Reply(
                    id = 2,
                    message = "Message 2",
                    isResolved = false
                )
            ),
            onReplyClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyList(
            replies = listOf(
                Reply(
                    id = 1,
                    message = "Message 1",
                    isResolved = false
                ),
                Reply(
                    id = 2,
                    message = "Message 2",
                    isResolved = false
                )
            ),
            onReplyClick = {}
        )
    }
}
