package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview
@Composable
fun ReplyConfirmationDialogPreview() {
    ReplyRadarTheme {
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
