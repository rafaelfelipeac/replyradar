package com.rafaelfelipeac.replyradar.fakes.useractions.data

import com.rafaelfelipeac.replyradar.features.useractions.data.database.dao.UserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity

class FakeUserActionDao : UserActionDao {
    val insertedEntities = mutableListOf<UserActionEntity>()

    override suspend fun insert(userActionEntity: UserActionEntity) {
        insertedEntities.add(userActionEntity)
    }
}
