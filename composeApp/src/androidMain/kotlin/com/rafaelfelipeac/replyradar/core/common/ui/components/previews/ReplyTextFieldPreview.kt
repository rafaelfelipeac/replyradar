package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextField
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplyTextFieldPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyTextField(
            value = "Value",
            placeholder = "Placeholder",
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTextFieldDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyTextField(
            value = "Value",
            placeholder = "Placeholder",
            onValueChange = {}
        )
    }
}
