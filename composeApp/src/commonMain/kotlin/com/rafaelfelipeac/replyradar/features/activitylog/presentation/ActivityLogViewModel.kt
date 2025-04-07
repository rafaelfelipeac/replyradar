package com.rafaelfelipeac.replyradar.features.activitylog.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.GetUserActionItemsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ActivityLogViewModel(
    private val getUserActionItemsUseCase: GetUserActionItemsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ActivityLogState())
    val state = _state

    init {
        getActivityLog()
    }

    private fun getActivityLog() = viewModelScope.launch {
        updateState { copy(isLoading = true) }

        getUserActionItemsUseCase
            .getUserActions()
            .collect { userActions ->
                updateState {
                    copy(
                        activityLogItems = userActions,
                        isLoading = false
                    )
                }
            }
    }

    private fun updateState(update: ActivityLogState.() -> ActivityLogState) {
        _state.update { it.update() }
    }
}
