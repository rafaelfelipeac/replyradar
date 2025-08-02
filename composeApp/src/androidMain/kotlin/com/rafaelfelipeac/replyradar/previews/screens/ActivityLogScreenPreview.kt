package com.rafaelfelipeac.replyradar.previews.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogScreen
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogState
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import com.rafaelfelipeac.replyradar.previews.shared.previewActivityLogItems

@Preview(showBackground = true)
@Composable
fun ActivityLogScreenEmptyPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ActivityLogScreen(
            state = ActivityLogState(
                isLoading = false,
                activityLogItems = emptyList()
            ),
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityLogScreenPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ActivityLogScreen(
            state = ActivityLogState(
                isLoading = false,
                activityLogItems = previewActivityLogItems
            ),
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityLogScreenEmptyDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ActivityLogScreen(
            state = ActivityLogState(
                isLoading = false,
                activityLogItems = emptyList()
            ),
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityLogScreenDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ActivityLogScreen(
            state = ActivityLogState(
                isLoading = false,
                activityLogItems = previewActivityLogItems
            ),
            onBackClick = {}
        )
    }
}
