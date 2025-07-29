package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.datetime.PlatformDatePicker
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun PlatformDatePickerPreview() {
    ReplyRadarTheme(darkTheme = false) {
        PlatformDatePicker(
            selectedDate = null,
            selectedTime = null,
            onDateSelected = {},
            confirmButtonText = "OK",
            dismissButtonText = "Cancelar",
            onTimeInvalidated = {},
            onDismiss = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlatformDatePickerDarkPreview() {
    ReplyRadarTheme(darkTheme = true) {
        PlatformDatePicker(
            selectedDate = null,
            selectedTime = null,
            onDateSelected = {},
            confirmButtonText = "OK",
            dismissButtonText = "Cancelar",
            onTimeInvalidated = {},
            onDismiss = {}
        )
    }
}
