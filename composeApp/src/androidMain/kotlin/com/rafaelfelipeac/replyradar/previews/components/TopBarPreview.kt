package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.TopBar
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        TopBar(
            onActivityLogClick = {},
            onSettingsClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        TopBar(
            onActivityLogClick = {},
            onSettingsClick = {}
        )
    }
}
