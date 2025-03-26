package com.rafaelfelipeac.replyradar.features.reply.domain

import com.rafaelfelipeac.replyradar.fakes.reply.data.FakeReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class ToggleResolveReplyUseCaseTest {

    @Test
    fun `toggleResolveReply should call repository and return toggled resolved state`() = runTest {
        val repository = FakeReplyRepository()
        val useCase = ToggleResolveReplyUseCaseImpl(repository)

        val reply = Reply(
            id = 1L,
            name = "Beatrix",
            subject = "Resolve this"
        )

        val result = useCase.toggleResolveReply(reply)

        assertEquals(true, result)
        assertEquals(1, repository.resolvedToggledReplies.size)
        assertEquals(reply, repository.resolvedToggledReplies.first())
    }
}
