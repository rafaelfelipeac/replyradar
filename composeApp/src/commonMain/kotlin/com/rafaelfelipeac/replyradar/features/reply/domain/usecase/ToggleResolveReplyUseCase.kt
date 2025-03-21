package com.rafaelfelipeac.replyradar.features.reply.domain.usecase

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository

interface ToggleResolveReplyUseCase {
    suspend fun toggleResolveReply(reply: Reply) : Boolean
}

class ToggleResolveReplyUseCaseImpl(
    private val repository: ReplyRepository
) : ToggleResolveReplyUseCase {

    override suspend fun toggleResolveReply(reply: Reply) : Boolean {
        val isResolved = !reply.isResolved

        repository.toggleReplyResolve(reply.copy(isResolved = isResolved))

        return isResolved
    }
}