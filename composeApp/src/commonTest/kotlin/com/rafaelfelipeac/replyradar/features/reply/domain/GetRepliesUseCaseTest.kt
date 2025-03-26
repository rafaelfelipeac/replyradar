package com.rafaelfelipeac.replyradar.features.reply.domain

import com.rafaelfelipeac.replyradar.fakes.reply.data.FakeReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest

class GetRepliesUseCaseImplTest {

    @Test
    fun `getReplies should call repository and return correct list`() = runTest {
        val expectedReplies = listOf(
            Reply(
                id = 1L,
                name = "Ana",
                subject = "Important message",
                isResolved = true
            )
        )

        val repository = FakeReplyRepository().apply {
            repliesToReturn = flowOf(expectedReplies)
        }

        val useCase = GetRepliesUseCaseImpl(repository)

        val result = useCase.getReplies(isResolved = true, isArchived = false).first()

        assertEquals(expectedReplies, result)
        assertEquals(true, repository.receivedIsResolved)
        assertEquals(false, repository.receivedIsArchived)
    }
}
