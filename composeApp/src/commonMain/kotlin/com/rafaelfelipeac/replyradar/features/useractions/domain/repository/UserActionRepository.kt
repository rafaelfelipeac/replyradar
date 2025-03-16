package com.rafaelfelipeac.replyradar.features.useractions.domain.repository

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType

interface UserActionRepository {
    suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    )
}
