package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.NotificationPermissionDialog
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(name = "Notification Dialog - Dark", showBackground = true)
@Composable
fun ReplyNotificationPermissionDialogPreviewDark() {
    ReplyRadarTheme(darkTheme = true) {
        NotificationPermissionDialog(
            onDismiss = {},
            onGoToSettings = {}
        )
    }
}

@Preview(name = "Notification Dialog - Light", showBackground = true)
@Composable
fun ReplyNotificationPermissionDialogPreviewLight() {
    ReplyRadarTheme(darkTheme = false) {
        NotificationPermissionDialog(
            onDismiss = {},
            onGoToSettings = {}
        )
    }
}
