package com.rafaelfelipeac.replyradar.features.useractions.data.repository

import com.rafaelfelipeac.replyradar.features.useractions.data.database.dao.UserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository

class UserActionRepositoryImpl(
    private val userActionDao: UserActionDao
) : UserActionRepository {

    override suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    ) {
        userActionDao.insert(
            actionType = actionType.value,
            targetType = targetType.value,
            targetId = targetId
        )
    }
}
