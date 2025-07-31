package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.datetime.PlatformDatePicker
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun PlatformDatePickerPreview() {
    ReplyRadarPreviewWrapper(darkTheme = false) {
        PlatformDatePicker(
            selectedDate = null,
            selectedTime = null,
            onDateSelected = {},
            confirmButtonText = PreviewStringsFake.replyListReminderDatePickerConfirmButton,
            dismissButtonText = PreviewStringsFake.replyListReminderDatePickerDismissButton,
            onTimeInvalidated = {},
            onDismiss = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlatformDatePickerDarkPreview() {
    ReplyRadarPreviewWrapper(darkTheme = true) {
        PlatformDatePicker(
            selectedDate = null,
            selectedTime = null,
            onDateSelected = {},
            confirmButtonText = PreviewStringsFake.replyListReminderDatePickerConfirmButton,
            dismissButtonText = PreviewStringsFake.replyListReminderDatePickerDismissButton,
            onTimeInvalidated = {},
            onDismiss = {}
        )
    }
}
