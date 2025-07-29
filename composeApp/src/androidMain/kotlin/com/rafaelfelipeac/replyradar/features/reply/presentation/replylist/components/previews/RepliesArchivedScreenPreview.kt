package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesArchivedScreen

@Preview(showBackground = true)
@Composable
fun RepliesArchivedScreenPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        RepliesArchivedScreen(
            state = ReplyListState(),
            onIntent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepliesArchivedScreenDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        RepliesArchivedScreen(
            state = ReplyListState(),
            onIntent = {}
        )
    }
}
