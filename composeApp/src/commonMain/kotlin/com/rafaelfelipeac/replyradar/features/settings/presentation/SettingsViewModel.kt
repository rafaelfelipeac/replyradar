package com.rafaelfelipeac.replyradar.features.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetLanguageUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectLanguage
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectTheme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Language
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Theme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Edit
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    getThemeUseCase: GetThemeUseCase,
    private val setThemeUseCase: SetThemeUseCase,
    getLanguageUseCase: GetLanguageUseCase,
    private val setLanguageUseCase: SetLanguageUseCase,
    private val logUserActionUseCase: LogUserActionUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())
    val state: StateFlow<SettingsState> = combine(
        getThemeUseCase.getTheme(),
        getLanguageUseCase.getLanguage()
    ) { theme, language ->
        SettingsState(theme = theme, language = language)
    }.stateIn(viewModelScope, SharingStarted.Eagerly, _state.value)

    fun onIntent(intent: SettingsIntent) {
        when (intent) {
            is OnSelectTheme -> onSelectTheme(theme = intent.theme)
            is OnSelectLanguage -> onSelectLanguage(language = intent.language)
        }
    }

    private fun onSelectTheme(theme: AppTheme) = viewModelScope.launch {
        setThemeUseCase.setTheme(theme)

        updateState { copy(theme = theme) }

        logUserAction(actionType = Edit, targetType = Theme)
    }

    private fun onSelectLanguage(language: AppLanguage) = viewModelScope.launch {
        setLanguageUseCase.setLanguage(language)

        updateState { copy(language = language) }

        logUserAction(actionType = Edit, targetType = Language)
    }

    private fun updateState(update: SettingsState.() -> SettingsState) {
        _state.update { it.update() }
    }

    private suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType
    ) {
        logUserActionUseCase.logUserAction(
            actionType = actionType,
            targetType = targetType
        )
    }
}
