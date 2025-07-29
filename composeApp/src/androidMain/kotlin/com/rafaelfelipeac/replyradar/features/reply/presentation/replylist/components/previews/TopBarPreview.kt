package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.TopBar

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    ReplyRadarTheme(
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
    ReplyRadarTheme(
        darkTheme = true
    ) {
        TopBar(
            onActivityLogClick = {},
            onSettingsClick = {}
        )
    }
}
