package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Composable
fun NotificationPermissionDialog(onDismiss: () -> Unit, onGoToSettings: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = LocalReplyRadarStrings.current.notificationPermissionDialogTitle)
        },
        text = {
            Text(
                text = LocalReplyRadarStrings.current.notificationPermissionDialogDescription
            )
        },
        confirmButton = {
            TextButton(onClick = onGoToSettings) {
                Text(LocalReplyRadarStrings.current.notificationPermissionDialogConfirmButton)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(LocalReplyRadarStrings.current.notificationPermissionDialogDismissButton)
            }
        }
    )
}

@Preview
@Composable
fun ReplyNotificationPermissionDialogPreview() {
    ReplyRadarTheme {
        NotificationPermissionDialog(
            onDismiss = {},
            onGoToSettings = {}
        )
    }
}
