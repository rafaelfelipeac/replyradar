package com.rafaelfelipeac.replyradar.features.settings.presentation

import com.rafaelfelipeac.replyradar.core.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme

data class SettingsState(
    val theme: AppTheme = AppTheme.SYSTEM,
    val language: AppLanguage = AppLanguage.SYSTEM,
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)
