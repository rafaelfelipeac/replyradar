package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.NotificationPermissionDialog
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview
@Composable
fun ReplyNotificationPermissionDialogPreview() {
    ReplyRadarTheme(
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
    ReplyRadarTheme(
        darkTheme = true
    ) {
        NotificationPermissionDialog(
            onDismiss = {},
            onGoToSettings = {}
        )
    }
}
