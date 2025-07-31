package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.util.AppConstants.ARCHIVED_INDEX
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesScreen
import com.rafaelfelipeac.replyradar.previews.Replies
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun RepliesArchivedScreenPreview() {
    ReplyRadarPreviewWrapper(darkTheme = false) {
        RepliesScreen(
            pageIndex = ARCHIVED_INDEX,
            state = ReplyListState(
                isLoading = false,
                archivedReplies = Replies.Archived.replies
            ),
            onIntent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepliesArchivedScreenDarkPreview() {
    ReplyRadarPreviewWrapper(darkTheme = true) {
        RepliesScreen(
            pageIndex = ARCHIVED_INDEX,
            state = ReplyListState(
                isLoading = false,
                archivedReplies = Replies.Archived.replies
            ),
            onIntent = {}
        )
    }
}
