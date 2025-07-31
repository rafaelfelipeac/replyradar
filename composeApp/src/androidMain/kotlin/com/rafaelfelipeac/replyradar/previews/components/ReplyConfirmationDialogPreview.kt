package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyConfirmationDialog
import com.rafaelfelipeac.replyradar.core.util.format
import com.rafaelfelipeac.replyradar.previews.PreviewStringsFake
import com.rafaelfelipeac.replyradar.previews.Replies
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview
@Composable
fun ReplyConfirmationDialogPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyConfirmationDialog(
            title = PreviewStringsFake.replyListDeleteDialogTitle,
            description =
                format(
                    PreviewStringsFake.replyListDeleteDialogDescription,
                    Replies.OnTheRadar.reply1.name
                ),
            confirm = PreviewStringsFake.replyListDeleteDialogConfirm,
            dismiss = PreviewStringsFake.replyListDeleteDialogDismiss,
            onDismiss = {},
            onConfirm = {}
        )
    }
}

@Preview
@Composable
fun ReplyConfirmationDialogDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyConfirmationDialog(
            title = PreviewStringsFake.replyListDeleteDialogTitle,
            description =
                format(
                    PreviewStringsFake.replyListDeleteDialogDescription,
                    Replies.OnTheRadar.reply1.name
                ),
            confirm = PreviewStringsFake.replyListDeleteDialogConfirm,
            dismiss = PreviewStringsFake.replyListDeleteDialogDismiss,
            onDismiss = {},
            onConfirm = {}
        )
    }
}
