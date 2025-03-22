package com.rafaelfelipeac.replyradar.features.useractions.data.repository

import com.rafaelfelipeac.replyradar.core.util.Clock
import com.rafaelfelipeac.replyradar.features.useractions.data.database.dao.UserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository

class UserActionRepositoryImpl(
    private val userActionDao: UserActionDao,
    private val clock: Clock
) : UserActionRepository {

    override suspend fun logUserAction(
        actionType: UserActionType,
        targetType: UserActionTargetType,
        targetId: Long?
    ) {
        userActionDao.insert(
            UserActionEntity(
                actionType = actionType.value,
                targetType = targetType.value,
                targetId = targetId,
                createdAt = clock.now()
            )
        )
    }
}
