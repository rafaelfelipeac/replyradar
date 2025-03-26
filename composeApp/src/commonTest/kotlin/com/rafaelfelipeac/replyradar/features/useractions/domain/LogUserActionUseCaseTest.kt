package com.rafaelfelipeac.replyradar.features.useractions.domain

import com.rafaelfelipeac.replyradar.fakes.useractions.data.FakeUserActionRepository
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Message
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Delete
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCaseImpl
import com.rafaelfelipeac.replyradar.targetId
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class LogUserActionUseCaseImplTest {

    @Test
    fun `logUserAction should call repository with correct params`() = runTest {
        val repository = FakeUserActionRepository()
        val useCase = LogUserActionUseCaseImpl(repository)

        val actionType = Delete
        val targetType = Message

        useCase.logUserAction(actionType, targetType, targetId)

        assertEquals(1, repository.loggedActions.size)

        val logged = repository.loggedActions.first()
        assertEquals(actionType, logged.actionType)
        assertEquals(targetType, logged.targetType)
        assertEquals(targetId, logged.targetId)
    }
}
