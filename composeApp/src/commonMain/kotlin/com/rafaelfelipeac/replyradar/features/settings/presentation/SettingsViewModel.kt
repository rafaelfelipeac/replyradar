package com.rafaelfelipeac.replyradar.features.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.core.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetLanguageUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectFeedback
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectLanguage
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectRate
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectTheme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Feedback
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Language
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Rate
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Theme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Edit
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Open
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(
    getThemeUseCase: GetThemeUseCase,
    private val setThemeUseCase: SetThemeUseCase,
    getLanguageUseCase: GetLanguageUseCase,
    private val setLanguageUseCase: SetLanguageUseCase,
    private val logUserActionUseCase: LogUserActionUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SettingsState())

    val state: StateFlow<SettingsState> = _state

    init {
        viewModelScope.launch {
            val theme = getThemeUseCase.getTheme().first()
            val language = getLanguageUseCase.getLanguage().first()

            _state.value = _state.value.copy(
                theme = theme,
                language = language
            )
        }
    }

    fun onIntent(intent: SettingsIntent) {
        when (intent) {
            is OnSelectTheme -> onSelectTheme(theme = intent.theme)
            is OnSelectLanguage -> onSelectLanguage(language = intent.language)
            OnSelectFeedback -> onSelectFeedback()
            OnSelectRate -> onSelectRate()
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

    private fun onSelectFeedback() = viewModelScope.launch {
        logUserAction(actionType = Open, targetType = Feedback)
    }

    private fun onSelectRate() = viewModelScope.launch {
        logUserAction(actionType = Open, targetType = Rate)
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
