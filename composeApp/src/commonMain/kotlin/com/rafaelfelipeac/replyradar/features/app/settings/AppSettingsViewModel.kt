package com.rafaelfelipeac.replyradar.features.app.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class AppSettingsViewModel(
    getThemeUseCase: GetThemeUseCase,
    getLanguageUseCase: GetLanguageUseCase
) : ViewModel() {

    val theme: StateFlow<AppTheme> = getThemeUseCase
        .getTheme()
        .stateIn(
            viewModelScope,
            Eagerly,
            AppTheme.SYSTEM
        )

    val language: StateFlow<AppLanguage> = getLanguageUseCase
        .getLanguage()
        .stateIn(
            viewModelScope,
            Eagerly,
            AppLanguage.SYSTEM
        )
}
