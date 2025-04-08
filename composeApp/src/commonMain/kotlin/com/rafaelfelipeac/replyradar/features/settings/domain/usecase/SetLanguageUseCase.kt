package com.rafaelfelipeac.replyradar.features.settings.domain.usecase

import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository

interface SetLanguageUseCase {
    suspend fun setLanguage(appLanguage: AppLanguage)
}

class SetLanguageUseCaseImpl(
    private val repository: SettingsRepository
) : SetLanguageUseCase {
    override suspend fun setLanguage(appLanguage: AppLanguage) {
        repository.setLanguage(appLanguage)
    }
}
