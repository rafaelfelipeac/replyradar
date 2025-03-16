package com.rafaelfelipeac.replyradar.features.useractions.data.repository

import com.rafaelfelipeac.replyradar.features.useractions.data.database.dao.UserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository

class UserActionRepositoryImpl(
    private val userActionDao: UserActionDao
) : UserActionRepository {

    override suspend fun logUserAction(actionType: String) {
        userActionDao.insert(UserActionEntity(actionType = actionType))
    }
}
