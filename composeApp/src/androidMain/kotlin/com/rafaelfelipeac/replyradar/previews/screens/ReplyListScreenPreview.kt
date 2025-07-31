package com.rafaelfelipeac.replyradar.previews.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import com.rafaelfelipeac.replyradar.previews.shared.Replies
import kotlinx.coroutines.flow.emptyFlow

@Preview(showBackground = true)
@Composable
fun ReplyListScreenOnTheRadarPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 0,
                isLoading = false,
                replies = Replies.OnTheRadar.replies
            ),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListScreenResolvedPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 1,
                isLoading = false,
                replies = Replies.Resolved.replies
            ),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListScreenArchivedPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 2,
                isLoading = false,
                replies = Replies.Archived.replies
            ),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListScreenOnTheRadarDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 0,
                isLoading = false,
                replies = Replies.OnTheRadar.replies
            ),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListScreenResolvedDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 1,
                isLoading = false,
                replies = Replies.Resolved.replies
            ),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListScreenArchivedDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 2,
                isLoading = false,
                replies = Replies.Archived.replies
            ),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}
