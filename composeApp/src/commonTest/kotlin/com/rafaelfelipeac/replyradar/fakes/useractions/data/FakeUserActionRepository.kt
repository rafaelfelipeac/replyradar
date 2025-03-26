package com.rafaelfelipeac.replyradar.fakes.useractions.data

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository

class FakeUserActionRepository : UserActionRepository {

    data class LoggedAction(
        val actionType: UserActionType,
        val targetType: UserActionTargetType,
        val targetId: Long?
    )

    val loggedActions = mutableListOf<LoggedAction>()

    override suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    ) {
        loggedActions += LoggedAction(actionType, targetType, targetId)
    }
}
