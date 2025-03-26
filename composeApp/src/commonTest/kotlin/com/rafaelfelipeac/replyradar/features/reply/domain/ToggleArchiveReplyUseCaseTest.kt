package com.rafaelfelipeac.replyradar.features.reply.domain

import com.rafaelfelipeac.replyradar.fakes.reply.data.FakeReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleArchiveReplyUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class ToggleArchiveReplyUseCaseTest {

    @Test
    fun `toggleArchiveReply should call repository and return toggled archive state`() = runTest {
        val repository = FakeReplyRepository()
        val useCase = ToggleArchiveReplyUseCaseImpl(repository)

        val reply = Reply(
            id = 1L,
            name = "Socrates",
            subject = "Archive?"
        )

        val result = useCase.toggleArchiveReply(reply)

        assertEquals(true, result)
        assertEquals(1, repository.archivedToggledReplies.size)
        assertEquals(reply, repository.archivedToggledReplies.first())
    }
}
