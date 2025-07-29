package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.util.AppConstants
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesScreen

@Preview(showBackground = true)
@Composable
fun RepliesScreenPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        RepliesScreen(
            pageIndex = AppConstants.ON_THE_RADAR_INDEX,
            state = ReplyListState(),
            onIntent = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RepliesScreenDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        RepliesScreen(
            pageIndex = AppConstants.ON_THE_RADAR_INDEX,
            state = ReplyListState(),
            onIntent = {}
        )
    }
}
