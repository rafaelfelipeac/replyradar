package com.rafaelfelipeac.replyradar.reply.domain.usecase

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.domain.repository.ReplyRepository

interface UpsertReplyUseCase {
    suspend fun upsertReply(reply: Reply)
}

class UpsertReplyUseCaseImpl(private val repository: ReplyRepository) : UpsertReplyUseCase {

    override suspend fun upsertReply(reply: Reply) {
        repository.upsertReply(reply)
    }
}