package com.rafaelfelipeac.replyradar.features.useractions.domain.repository

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import kotlinx.coroutines.flow.Flow

interface UserActionRepository {
    suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    )

    suspend fun getUserActions(): Flow<List<UserAction>>
}
