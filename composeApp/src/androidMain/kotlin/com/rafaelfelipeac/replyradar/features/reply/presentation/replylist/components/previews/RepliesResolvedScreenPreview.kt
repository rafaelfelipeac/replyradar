package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesResolvedScreen

@Preview(showBackground = true)
@Composable
fun RepliesResolvedScreenPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        RepliesResolvedScreen(
            state = ReplyListState(),
            onIntent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepliesResolvedScreenDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        RepliesResolvedScreen(
            state = ReplyListState(),
            onIntent = {}
        )
    }
}
