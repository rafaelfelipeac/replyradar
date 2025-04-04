package com.rafaelfelipeac.replyradar.features.settings.presentation

import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM

data class SettingsState(
    val theme: AppTheme = SYSTEM,
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
)
