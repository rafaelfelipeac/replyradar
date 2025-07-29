package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.datetime.PlatformTimePicker
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun PlatformTimePickerPreview() {
    ReplyRadarTheme(darkTheme = false) {
        PlatformTimePicker(
            selectedTime = null,
            selectedDate = null,
            onTimeSelected = {},
            onDismiss = {},
            confirmButtonText = "OK",
            dismissButtonText = "Cancelar",
            pickerTimeTitle = "Escolha um horário"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlatformTimePickerDarkPreview() {
    ReplyRadarTheme(darkTheme = true) {
        PlatformTimePicker(
            selectedTime = null,
            selectedDate = null,
            onTimeSelected = {},
            onDismiss = {},
            confirmButtonText = "OK",
            dismissButtonText = "Cancelar",
            pickerTimeTitle = "Escolha um horário"
        )
    }
}
