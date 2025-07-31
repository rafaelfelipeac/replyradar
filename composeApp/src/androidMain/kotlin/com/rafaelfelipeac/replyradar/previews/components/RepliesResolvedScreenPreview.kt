package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.util.AppConstants.RESOLVED_INDEX
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesScreen
import com.rafaelfelipeac.replyradar.previews.Replies
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun RepliesResolvedScreenPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        RepliesScreen(
            pageIndex = RESOLVED_INDEX,
            state = ReplyListState(
                isLoading = false,
                resolvedReplies = Replies.Resolved.replies
            ),
            onIntent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepliesResolvedScreenDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        RepliesScreen(
            pageIndex = RESOLVED_INDEX,
            state = ReplyListState(
                isLoading = false,
                resolvedReplies = Replies.Resolved.replies
            ),
            onIntent = {}
        )
    }
}
