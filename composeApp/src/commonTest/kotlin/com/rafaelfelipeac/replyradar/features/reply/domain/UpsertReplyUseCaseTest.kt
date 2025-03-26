package com.rafaelfelipeac.replyradar.features.reply.domain

import com.rafaelfelipeac.replyradar.fakes.reply.data.FakeReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class UpsertReplyUseCaseTest {

    @Test
    fun `upsertReply should call repository and return inserted id`() = runTest {
        val repository = FakeReplyRepository()
        val useCase = UpsertReplyUseCaseImpl(repository)

        val reply = Reply(
            id = 0L,
            name = "Rose",
            subject = "New subject"
        )

        val expectedId = 99L
        repository.insertedReplyId = expectedId

        val result = useCase.upsertReply(reply)

        assertEquals(expectedId, result)
        assertEquals(1, repository.upsertedReplies.size)
        assertEquals(reply, repository.upsertedReplies.first())
    }
}
