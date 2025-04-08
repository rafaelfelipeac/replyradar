package com.rafaelfelipeac.replyradar.fakes.settings.data

import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeSettingsRepository(
    var language: AppLanguage = AppLanguage.SYSTEM,
    var theme: AppTheme = AppTheme.SYSTEM
) : SettingsRepository {

    override fun getLanguage(): Flow<AppLanguage> {
        return flowOf(language)
    }

    override suspend fun setLanguage(language: AppLanguage) {
        this.language = language
    }

    override fun getTheme(): Flow<AppTheme> {
        return flowOf(theme)
    }

    override suspend fun setTheme(theme: AppTheme) {
        this.theme = theme
    }
}
