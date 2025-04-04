package com.rafaelfelipeac.replyradar.features.settings.domain.usecase

import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

interface GetThemeUseCase {
    fun getTheme(): Flow<AppTheme>
}

class GetThemeUseCaseImpl(
    private val repository: SettingsRepository
) : GetThemeUseCase {
    override fun getTheme(): Flow<AppTheme> {
        return repository.getTheme()
    }
}
