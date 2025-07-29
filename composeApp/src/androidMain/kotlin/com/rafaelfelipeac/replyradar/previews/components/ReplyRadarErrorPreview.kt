package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarError
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(name = "Error - Dark", showBackground = true)
@Composable
fun ReplyRadarErrorPreviewDark() {
    ReplyRadarTheme(darkTheme = true) {
        ReplyRadarError()
    }
}

@Preview(name = "Error - Light", showBackground = true)
@Composable
fun ReplyRadarErrorPreviewLight() {
    ReplyRadarTheme(darkTheme = false) {
        ReplyRadarError()
    }
}
