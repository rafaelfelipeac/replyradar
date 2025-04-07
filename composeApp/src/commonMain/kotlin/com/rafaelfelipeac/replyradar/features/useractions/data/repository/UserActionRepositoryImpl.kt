package com.rafaelfelipeac.replyradar.features.useractions.data.repository

import com.rafaelfelipeac.replyradar.core.util.Clock
import com.rafaelfelipeac.replyradar.features.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.dao.UserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity
import com.rafaelfelipeac.replyradar.features.useractions.data.mapper.toUserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class UserActionRepositoryImpl(
    private val userActionDao: UserActionDao,
    private val replyDao: ReplyDao,
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

    override suspend fun getUserActions(): Flow<List<UserAction>> {
        return userActionDao.getUserActions().map { userActionEntities ->
            userActionEntities.map { entity ->
                val targetName = entity.targetId?.let { targetId ->
                    withContext(Dispatchers.IO) {
                        replyDao.getReply(targetId)?.name
                    }
                }

                entity.toUserAction(targetName = targetName)
            }.reversed()
        }
    }
}
