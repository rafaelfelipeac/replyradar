package com.rafaelfelipeac.replyradar.reply.domain.usecase

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.domain.repository.ReplyRepository

interface DeleteReplyUseCase {
    suspend fun deleteReply(reply: Reply)
}

class DeleteReplyUseCaseImpl(
    private val repository: ReplyRepository
) : DeleteReplyUseCase {

    override suspend fun deleteReply(reply: Reply) {
        repository.deleteReply(reply)
    }
}