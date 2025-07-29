package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyProgress
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(name = "Progress - Dark", showBackground = true)
@Composable
fun ReplyProgressPreviewDark() {
    ReplyRadarTheme(darkTheme = true) {
        ReplyProgress()
    }
}

@Preview(name = "Progress - Light", showBackground = true)
@Composable
fun ReplyProgressPreviewLight() {
    ReplyRadarTheme(darkTheme = false) {
        ReplyProgress()
    }
}
