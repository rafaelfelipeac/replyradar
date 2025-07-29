package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyToggle
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplyTogglePreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyToggle(
            isResolved = false,
            onToggle = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyToggleDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyToggle(
            isResolved = false,
            onToggle = {}
        )
    }
}
