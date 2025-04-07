package com.rafaelfelipeac.replyradar.fakes.useractions.data

import com.rafaelfelipeac.replyradar.features.useractions.data.database.dao.UserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeUserActionDao : UserActionDao {
    val insertedEntities = mutableListOf<UserActionEntity>()

    override suspend fun insert(userActionEntity: UserActionEntity) {
        insertedEntities.add(userActionEntity)
    }

    override fun getUserActions(): Flow<List<UserActionEntity>> {
        return flowOf(insertedEntities)
    }
}
