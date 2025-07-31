package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.ReplyListItem
import com.rafaelfelipeac.replyradar.previews.Replies
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyListItemPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListItem(
            reply = Replies.OnTheRadar.reply1,
            onClick = {},
            onToggle = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListItemPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListItem(
            reply = Replies.OnTheRadar.reply2,
            onClick = {},
            onToggle = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListItemDarkPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListItem(
            reply = Replies.OnTheRadar.reply1,
            onClick = {},
            onToggle = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListItemDarkPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListItem(
            reply = Replies.OnTheRadar.reply2,
            onClick = {},
            onToggle = {}
        )
    }
}
