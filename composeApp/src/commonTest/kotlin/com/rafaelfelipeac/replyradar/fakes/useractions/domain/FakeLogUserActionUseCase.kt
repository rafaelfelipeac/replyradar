package com.rafaelfelipeac.replyradar.fakes.useractions.domain

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCase

class FakeLogUserActionUseCase : LogUserActionUseCase {
    val loggedActions = mutableListOf<Pair<UserActionType, Long?>>()

    override suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    ) {
        loggedActions += (actionType to targetId)
    }
}