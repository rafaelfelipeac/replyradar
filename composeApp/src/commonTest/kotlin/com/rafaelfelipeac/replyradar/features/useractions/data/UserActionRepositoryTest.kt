package com.rafaelfelipeac.replyradar.features.useractions.data

import app.cash.turbine.test
import com.rafaelfelipeac.replyradar.fakes.core.util.FakeClock
import com.rafaelfelipeac.replyradar.fakes.reply.data.FakeReplyDao
import com.rafaelfelipeac.replyradar.fakes.useractions.data.FakeUserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity
import com.rafaelfelipeac.replyradar.features.useractions.data.repository.UserActionRepositoryImpl
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Message
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Create
import com.rafaelfelipeac.replyradar.now
import com.rafaelfelipeac.replyradar.targetId
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class UserActionRepositoryTest {

    private val userActionDao = FakeUserActionDao()
    private val replyDao = FakeReplyDao()
    private val clock = FakeClock(now)

    private val repository = UserActionRepositoryImpl(
        userActionDao = userActionDao,
        replyDao = replyDao,
        clock = clock
    )

    @Test
    fun `logUserAction should insert correct entity`() = runTest {
        val actionType = Create
        val targetType = Message

        repository.logUserAction(actionType, targetType, targetId)

        assertEquals(1, userActionDao.insertedEntities.size)

        val entity = userActionDao.insertedEntities.first()
        assertEquals(actionType.value, entity.actionType)
        assertEquals(targetType.value, entity.targetType)
        assertEquals(targetId, entity.targetId)
        assertEquals(now, entity.createdAt)
    }

    @Test
    fun `getUserActions should return mapped UserAction list with targetName`() = runTest {
        val replyName = "Reply 123"
        replyDao.setReplyName(targetId, replyName)

        userActionDao.insertedEntities.add(
            UserActionEntity(
                id = 1L,
                actionType = Create.value,
                targetType = Message.value,
                targetId = targetId,
                createdAt = now
            )
        )

        repository.getUserActions().test {
            val result = awaitItem()

            assertEquals(1, result.size)

            val action = result.first()
            assertEquals(Create, action.actionType)
            assertEquals(Message, action.targetType)
            assertEquals(replyName, action.targetName)
            assertEquals(now, action.createdAt)

            cancelAndIgnoreRemainingEvents()
        }
    }
}
