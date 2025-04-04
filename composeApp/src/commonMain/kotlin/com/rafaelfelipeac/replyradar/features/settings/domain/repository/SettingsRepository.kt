package com.rafaelfelipeac.replyradar.features.settings.domain.repository

import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getTheme(): Flow<AppTheme>
    suspend fun setTheme(theme: AppTheme)
}
