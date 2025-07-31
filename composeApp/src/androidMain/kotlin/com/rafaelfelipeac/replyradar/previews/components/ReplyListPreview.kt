package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.ReplyList
import com.rafaelfelipeac.replyradar.previews.Replies
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyListPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            ReplyList(
                replies = Replies.OnTheRadar.replies,
                onReplyClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            ReplyList(
                replies = Replies.OnTheRadar.replies,
                onReplyClick = {}
            )
        }
    }
}
