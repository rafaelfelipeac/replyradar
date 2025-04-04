package com.rafaelfelipeac.replyradar.features.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val getThemeUseCase: GetThemeUseCase,
    private val setThemeUseCase: SetThemeUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(SettingsState())
    val state = _state.asStateFlow()

    init {
        getTheme()
    }

    fun onIntent(intent: SettingsIntent) {
        when (intent) {
            is OnSelectTheme -> onSelectTheme(theme = intent.theme)
        }
    }

    private fun getTheme() = viewModelScope.launch {
        updateState { copy(isLoading = true) }

        getThemeUseCase
            .getTheme()
            .collect { theme ->
                updateState {
                    copy(
                        isLoading = false,
                        theme = theme
                    )
                }
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

    private fun updateState(update: SettingsState.() -> SettingsState) {
        _state.update { it.update() }
    }
}
