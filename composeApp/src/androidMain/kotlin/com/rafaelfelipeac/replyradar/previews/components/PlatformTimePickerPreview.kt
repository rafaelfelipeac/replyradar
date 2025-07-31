package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.datetime.PlatformTimePicker
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun PlatformTimePickerPreview() {
    ReplyRadarPreviewWrapper(darkTheme = false) {
        PlatformTimePicker(
            selectedTime = null,
            selectedDate = null,
            onTimeSelected = {},
            onDismiss = {},
            confirmButtonText = PreviewStringsFake.replyListReminderTimePickerConfirmButton,
            dismissButtonText = PreviewStringsFake.replyListReminderTimePickerDismissButton,
            pickerTimeTitle = PreviewStringsFake.replyListReminderTimePickerTitle,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlatformTimePickerDarkPreview() {
    ReplyRadarPreviewWrapper(darkTheme = true) {
        PlatformTimePicker(
            selectedTime = null,
            selectedDate = null,
            onTimeSelected = {},
            onDismiss = {},
            confirmButtonText = PreviewStringsFake.replyListReminderTimePickerConfirmButton,
            dismissButtonText = PreviewStringsFake.replyListReminderTimePickerDismissButton,
            pickerTimeTitle = PreviewStringsFake.replyListReminderTimePickerTitle,
        )
    }
}
