package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTab
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplyTabPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyTab(
            modifier = Modifier,
            selected = true,
            onClick = {},
            text = "Tab"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTabDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyTab(
            modifier = Modifier,
            selected = true,
            onClick = {},
            text = "Tab"
        )
    }
}
