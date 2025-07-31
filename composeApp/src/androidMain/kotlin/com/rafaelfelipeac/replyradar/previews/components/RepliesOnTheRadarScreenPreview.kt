package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.util.AppConstants.ON_THE_RADAR_INDEX
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesScreen
import com.rafaelfelipeac.replyradar.previews.shared.Replies
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun RepliesScreenPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        RepliesScreen(
            pageIndex = ON_THE_RADAR_INDEX,
            state = ReplyListState(
                isLoading = false,
                replies = Replies.OnTheRadar.replies
            ),
            onIntent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepliesScreenDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        RepliesScreen(
            pageIndex = ON_THE_RADAR_INDEX,
            state = ReplyListState(
                isLoading = false,
                replies = Replies.OnTheRadar.replies
            ),
            onIntent = {}
        )
    }
}
