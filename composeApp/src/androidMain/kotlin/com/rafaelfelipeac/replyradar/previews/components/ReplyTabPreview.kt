package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTab
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplyTabPreview() {
    ReplyRadarTheme {
        ReplyTab(
            modifier = Modifier,
            selected = true,
            onClick = {},
            text = "Tab"
        )
    }
}
