package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.ReplyListItem

@Preview(showBackground = true)
@Composable
fun ReplyListItemPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyListItem(
            reply = Reply(
                id = 1,
                message = "Message",
                isResolved = false,
                name = "Name",
                subject = "Subject"
            ),
            onClick = {},
            onToggle = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListItemDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyListItem(
            reply = Reply(
                id = 1,
                message = "Message",
                isResolved = false,
                name = "Name",
                subject = "Subject"
            ),
            onClick = {},
            onToggle = {}
        )
    }
}
