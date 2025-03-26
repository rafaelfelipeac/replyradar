package com.rafaelfelipeac.replyradar.features.reply.domain.usecase

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository

interface ToggleArchiveReplyUseCase {
    suspend fun toggleArchiveReply(reply: Reply): Boolean
}

class ToggleArchiveReplyUseCaseImpl(
    private val repository: ReplyRepository
) : ToggleArchiveReplyUseCase {

    override suspend fun toggleArchiveReply(reply: Reply): Boolean {
        repository.toggleReplyArchive(reply)

        return !reply.isArchived
    }
}
