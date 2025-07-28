package com.rafaelfelipeac.replyradar.fakes.settings.domain

import com.rafaelfelipeac.replyradar.core.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.SYSTEM
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeGetLanguageUseCase : GetLanguageUseCase {
    var language: AppLanguage = SYSTEM

    override fun getLanguage(): Flow<AppLanguage> {
        return flowOf(language)
    }
}
