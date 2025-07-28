package com.rafaelfelipeac.replyradar.features.settings.presentation

import com.rafaelfelipeac.replyradar.core.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme

sealed interface SettingsIntent {
    data class OnSelectTheme(val theme: AppTheme) : SettingsIntent
    data class OnSelectLanguage(val language: AppLanguage) : SettingsIntent
    data object OnSelectFeedback : SettingsIntent
    data object OnSelectRate : SettingsIntent
}
