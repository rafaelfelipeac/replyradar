package com.rafaelfelipeac.replyradar.features.app.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import kotlinx.coroutines.flow.SharingStarted.Companion.Eagerly
import kotlinx.coroutines.flow.stateIn

class AppSettingsViewModel(
    getThemeUseCase: GetThemeUseCase,
) : ViewModel() {

    val theme = getThemeUseCase
        .getTheme()
        .stateIn(
            viewModelScope,
            Eagerly,
            SYSTEM
        )
}
