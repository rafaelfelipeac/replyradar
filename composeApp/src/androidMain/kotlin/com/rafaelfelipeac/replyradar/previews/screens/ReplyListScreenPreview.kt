package com.rafaelfelipeac.replyradar.previews.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import com.rafaelfelipeac.replyradar.previews.shared.Replies
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import kotlinx.coroutines.flow.emptyFlow

// Note: We're not using @PreviewParameter here due to limitations in Compose Preview when used in Kotlin Multiplatform (KMP).
// Although @PreviewParameter is ideal for generating multiple previews from a provider, it causes runtime errors (NPE)
// in KMP projects because the IDE tries to invoke the function without a parameter.
// As a workaround, we use separate @Preview-annotated functions with hardcoded configurations instead.

@Preview(showBackground = true)
@Composable
fun ReplyListScreenOnTheRadarEmptyPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 0,
                isLoading = false,
                replies = emptyList()
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
fun ReplyListScreenResolvedEmptyPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 1,
                isLoading = false,
                resolvedReplies = emptyList()
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
                resolvedReplies = Replies.Resolved.replies
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
fun ReplyListScreenArchivedEmptyPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 2,
                isLoading = false,
                archivedReplies = emptyList()
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
                archivedReplies = Replies.Archived.replies
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
fun ReplyListScreenOnTheRadarEmptyDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 0,
                isLoading = false,
                replies = emptyList()
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
fun ReplyListScreenResolvedEmptyDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 1,
                isLoading = false,
                resolvedReplies = emptyList()
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
                resolvedReplies = Replies.Resolved.replies
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
fun ReplyListScreenArchivedEmptyDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyListScreen(
            state = ReplyListState(
                selectedTabIndex = 2,
                isLoading = false,
                archivedReplies = emptyList()
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
                archivedReplies = Replies.Archived.replies
            ),
            effect = emptyFlow(),
            onIntent = {},
            onSettingsClick = {},
            onActivityLogClick = {}
        )
    }
}
