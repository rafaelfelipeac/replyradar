package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyConfirmationDialog
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(name = "Confirmation Dialog - Dark", showBackground = true)
@Composable
fun ReplyConfirmationDialogPreviewDark() {
    ReplyRadarTheme(darkTheme = true) {
        ReplyConfirmationDialog(
            title = "Title",
            description = "Description",
            confirm = "Confirm",
            dismiss = "Dismiss",
            onDismiss = {},
            onConfirm = {}
        )
    }
}

@Preview(name = "Confirmation Dialog - Light", showBackground = true)
@Composable
fun ReplyConfirmationDialogPreviewLight() {
    ReplyRadarTheme(darkTheme = false) {
        ReplyConfirmationDialog(
            title = "Title",
            description = "Description",
            confirm = "Confirm",
            dismiss = "Dismiss",
            onDismiss = {},
            onConfirm = {}
        )
    }
}
