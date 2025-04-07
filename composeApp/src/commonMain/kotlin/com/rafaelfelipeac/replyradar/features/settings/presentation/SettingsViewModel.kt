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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val getThemeUseCase: GetThemeUseCase,
    private val setThemeUseCase: SetThemeUseCase,
    private val getLanguageUseCase: GetLanguageUseCase,
    private val setLanguageUseCase: SetLanguageUseCase
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
        updateState { copy(isLoading = true) }

        setThemeUseCase.setTheme(theme)

        updateState {
            copy(
                isLoading = false,
                theme = theme
            )
        }
    }

    private fun getLanguage() = viewModelScope.launch {
        updateState { copy(isLoading = true) }

        getLanguageUseCase
            .getLanguage()
            .collect { language ->
                updateState {
                    copy(
                        isLoading = false,
                        language = language
                    )
                }
            }
    }

    private fun onSelectLanguage(language: AppLanguage) = viewModelScope.launch {
        updateState { copy(isLoading = true) }

        setLanguageUseCase.setLanguage(language)

        updateState {
            copy(
                isLoading = false,
                language = language
            )
        }
    }

    private fun updateState(update: SettingsState.() -> SettingsState) {
        _state.update { it.update() }
    }
}
