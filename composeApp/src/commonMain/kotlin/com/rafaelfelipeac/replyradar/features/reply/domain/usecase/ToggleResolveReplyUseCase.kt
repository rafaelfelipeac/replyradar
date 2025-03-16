package com.rafaelfelipeac.replyradar.features.reply.domain.usecase

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository

interface ToggleResolveReplyUseCase {
    suspend fun toggleResolveReply(reply: Reply)
}

class ToggleResolveReplyUseCaseImpl(
    private val repository: ReplyRepository
) : ToggleResolveReplyUseCase {

    override suspend fun toggleResolveReply(reply: Reply) {
        repository.toggleReplyResolve(reply.copy(isResolved = !reply.isResolved))
    }
}