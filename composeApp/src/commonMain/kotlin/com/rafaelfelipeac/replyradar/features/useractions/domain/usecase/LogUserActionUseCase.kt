package com.rafaelfelipeac.replyradar.features.useractions.domain.usecase

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository

interface LogUserActionUseCase {
    suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    )
}

class LogUserActionUseCaseImpl(
    private val repository: UserActionRepository
) : LogUserActionUseCase {

    override suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    ) {
        repository.logUserAction(
            actionType = actionType,
            targetType = targetType,
            targetId = targetId
        )
    }
}
