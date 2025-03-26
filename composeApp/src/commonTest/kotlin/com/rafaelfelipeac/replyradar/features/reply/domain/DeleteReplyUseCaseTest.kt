package com.rafaelfelipeac.replyradar.features.reply.domain

import com.rafaelfelipeac.replyradar.fakes.reply.data.FakeReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class DeleteReplyUseCaseImplTest {

    @Test
    fun `deleteReply should call repository with correct reply`() = runTest {
        val repository = FakeReplyRepository()
        val useCase = DeleteReplyUseCaseImpl(repository)

        val reply = Reply(
            id = 42L,
            name = "Delete me",
            subject = "Some subject"
        )

        useCase.deleteReply(reply)

        assertEquals(1, repository.deletedReplies.size)
        assertEquals(reply, repository.deletedReplies.first())
    }
}
