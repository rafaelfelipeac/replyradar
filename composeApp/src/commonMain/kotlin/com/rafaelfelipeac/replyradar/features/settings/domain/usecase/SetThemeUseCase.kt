package com.rafaelfelipeac.replyradar.features.settings.domain.usecase

import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository

interface SetThemeUseCase {
    suspend fun setTheme(appTheme: AppTheme)
}

class SetThemeUseCaseImpl(
    private val repository: SettingsRepository
) : SetThemeUseCase {
    override suspend fun setTheme(appTheme: AppTheme) {
        repository.setTheme(appTheme)
    }
}
