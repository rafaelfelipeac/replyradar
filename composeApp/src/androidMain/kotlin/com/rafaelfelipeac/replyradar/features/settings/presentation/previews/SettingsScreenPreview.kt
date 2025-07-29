package com.rafaelfelipeac.replyradar.features.settings.presentation.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsScreen

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        SettingsScreen(
            onBackClick = {},
            onActivityLogClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        SettingsScreen(
            onBackClick = {},
            onActivityLogClick = {}
        )
    }
}
