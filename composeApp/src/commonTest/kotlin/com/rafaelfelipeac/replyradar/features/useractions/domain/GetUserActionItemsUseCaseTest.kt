package com.rafaelfelipeac.replyradar.features.useractions.domain

import app.cash.turbine.test
import com.rafaelfelipeac.replyradar.fakes.useractions.data.FakeUserActionRepository
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Message
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Create
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.GetUserActionItemsUseCase
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.GetUserActionItemsUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class GetUserActionItemsUseCaseTest {

    private val fakeRepository = FakeUserActionRepository()
    private val getUserActionItemsUseCase: GetUserActionItemsUseCase =
        GetUserActionItemsUseCaseImpl(fakeRepository)

    @Test
    fun `should return user actions from repository`() = runTest {
        val expectedActionType = Create
        val expectedTargetType = Message
        val expectedTargetId = 123L

        fakeRepository.logUserAction(
            actionType = expectedActionType,
            targetType = expectedTargetType,
            targetId = expectedTargetId
        )

        getUserActionItemsUseCase.getUserActions().test {
            val userActions = awaitItem()

            assertEquals(1, userActions.size)

            val action = userActions.first()
            assertEquals(expectedActionType, action.actionType)
            assertEquals(expectedTargetType, action.targetType)
            assertEquals(null, action.targetName)
            assertEquals(0L, action.createdAt)

            cancelAndIgnoreRemainingEvents()
        }
    }
}
