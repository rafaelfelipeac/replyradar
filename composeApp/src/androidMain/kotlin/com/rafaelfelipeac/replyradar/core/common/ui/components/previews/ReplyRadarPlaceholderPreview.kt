package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarPlaceholder
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplyRadarPlaceholderPreview() {
    ReplyRadarTheme {
        ReplyRadarPlaceholder(
            message = "Placeholder"
        )
    }
}
