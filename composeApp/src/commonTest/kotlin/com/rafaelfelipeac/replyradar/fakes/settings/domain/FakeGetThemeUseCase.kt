package com.rafaelfelipeac.replyradar.fakes.settings.domain

import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeGetThemeUseCase : GetThemeUseCase {
    var theme: AppTheme = SYSTEM

    override fun getTheme(): Flow<AppTheme> {
        return flowOf(theme)
    }
}
