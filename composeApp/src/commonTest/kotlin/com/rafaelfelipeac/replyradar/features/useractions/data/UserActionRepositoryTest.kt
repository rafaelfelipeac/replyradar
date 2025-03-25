package com.rafaelfelipeac.replyradar.features.useractions.data

import com.rafaelfelipeac.replyradar.fakes.core.util.FakeClock
import com.rafaelfelipeac.replyradar.fakes.useractions.data.FakeUserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.repository.UserActionRepositoryImpl
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Message
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Create
import com.rafaelfelipeac.replyradar.now
import com.rafaelfelipeac.replyradar.targetId
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class UserActionRepositoryImplTest {

    @Test
    fun `logUserAction should insert correct entity`() = runTest {
        val dao = FakeUserActionDao()
        val clock = FakeClock(now)
        val repository = UserActionRepositoryImpl(dao, clock)

        val actionType = Create
        val targetType = Message

        repository.logUserAction(actionType, targetType, targetId)

        assertEquals(1, dao.insertedEntities.size)

        val entity = dao.insertedEntities.first()
        assertEquals(actionType.value, entity.actionType)
        assertEquals(targetType.value, entity.targetType)
        assertEquals(targetId, entity.targetId)
        assertEquals(now, entity.createdAt)
    }
}
