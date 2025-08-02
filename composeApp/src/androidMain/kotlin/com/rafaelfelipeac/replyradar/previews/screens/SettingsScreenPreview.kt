package com.rafaelfelipeac.replyradar.previews.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.ENGLISH
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.LIGHT
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsScreen
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsState
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import com.rafaelfelipeac.replyradar.previews.shared.appVersion

@Preview(showBackground = true)
@Composable
fun SettingsScreenEnglishPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        SettingsScreen(
            state = SettingsState(
                theme = LIGHT,
                language = ENGLISH,
                isLoading = false,
            ),
            onBackClick = {},
            onActivityLogClick = {},
            onIntent = {},
            appVersion = appVersion
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenDarkEnglishPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        SettingsScreen(
            state = SettingsState(
                theme = DARK,
                language = ENGLISH,
                isLoading = false,
            ),
            onBackClick = {},
            onActivityLogClick = {},
            onIntent = {},
            appVersion = appVersion
        )
    }
}
