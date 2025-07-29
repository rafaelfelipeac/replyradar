package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyProgress
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplyProgressPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyProgress()
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyProgressDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyProgress()
    }
}
