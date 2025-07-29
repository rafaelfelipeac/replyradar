package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyButton
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(name = "Button - Dark", showBackground = true)
@Composable
fun ReplyButtonPreviewDark() {
    ReplyRadarTheme(darkTheme = true) {
        ReplyButton(
            modifier = Modifier,
            text = "Button",
            onClick = {}
        )
    }
}

@Preview(name = "Button - Light", showBackground = true)
@Composable
fun ReplyButtonPreviewLight() {
    ReplyRadarTheme(darkTheme = false) {
        ReplyButton(
            modifier = Modifier,
            text = "Button",
            onClick = {}
        )
    }
}
