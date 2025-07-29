package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import kotlinx.coroutines.flow.emptyFlow

@Preview(showBackground = true)
@Composable
fun ReplyListScreenPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyListScreen(
            state = ReplyListState(),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListScreenDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyListScreen(
            state = ReplyListState(),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}
