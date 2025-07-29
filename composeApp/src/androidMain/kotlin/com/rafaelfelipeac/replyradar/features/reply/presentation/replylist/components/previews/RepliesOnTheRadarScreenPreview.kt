package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesOnTheRadarScreen

@Preview(showBackground = true)
@Composable
fun RepliesOnTheRadarScreenPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        RepliesOnTheRadarScreen(
            state = ReplyListState(),
            onIntent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepliesOnTheRadarScreenDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        RepliesOnTheRadarScreen(
            state = ReplyListState(),
            onIntent = {}
        )
    }
}
