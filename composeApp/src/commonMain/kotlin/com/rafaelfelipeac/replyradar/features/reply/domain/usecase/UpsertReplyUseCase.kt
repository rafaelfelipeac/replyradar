package com.rafaelfelipeac.replyradar.features.reply.domain.usecase

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository

interface UpsertReplyUseCase {
    suspend fun upsertReply(reply: Reply): Long
}

class UpsertReplyUseCaseImpl(
    private val repository: ReplyRepository
) : UpsertReplyUseCase {

    override suspend fun upsertReply(reply: Reply) = repository.upsertReply(reply)
}
