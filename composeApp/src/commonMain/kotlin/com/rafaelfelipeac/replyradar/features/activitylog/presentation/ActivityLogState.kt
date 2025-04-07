package com.rafaelfelipeac.replyradar.features.activitylog.presentation

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction

data class ActivityLogState(
    val activityLogItems: List<UserAction> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)
