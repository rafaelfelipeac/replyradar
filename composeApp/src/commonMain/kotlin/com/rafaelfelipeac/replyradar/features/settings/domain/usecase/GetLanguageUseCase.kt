package com.rafaelfelipeac.replyradar.features.settings.domain.usecase

import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow

interface GetLanguageUseCase {
    fun getLanguage(): Flow<AppLanguage>
}

class GetLanguageUseCaseImpl(
    private val repository: SettingsRepository
) : GetLanguageUseCase {
    override fun getLanguage(): Flow<AppLanguage> {
        return repository.getLanguage()
    }
}
