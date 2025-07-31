package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.NotificationPermissionDialog
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview
@Composable
fun ReplyNotificationPermissionDialogPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        NotificationPermissionDialog(
            onDismiss = {},
            onGoToSettings = {}
        )
    }
}

@Preview
@Composable
fun ReplyNotificationPermissionDialogDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        NotificationPermissionDialog(
            onDismiss = {},
            onGoToSettings = {}
        )
    }
}
