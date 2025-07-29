package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarPlaceholder
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(name = "Placeholder - Dark", showBackground = true)
@Composable
fun ReplyRadarPlaceholderPreviewDark() {
    ReplyRadarTheme(darkTheme = true) {
        ReplyRadarPlaceholder(
            message = "Placeholder"
        )
    }
}

@Preview(name = "Placeholder - Light", showBackground = true)
@Composable
fun ReplyRadarPlaceholderPreviewLight() {
    ReplyRadarTheme(darkTheme = false) {
        ReplyRadarPlaceholder(
            message = "Placeholder"
        )
    }
}
