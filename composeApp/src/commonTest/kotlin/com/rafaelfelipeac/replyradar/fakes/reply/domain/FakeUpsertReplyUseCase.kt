package com.rafaelfelipeac.replyradar.fakes.reply.domain

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCase

class FakeUpsertReplyUseCase : UpsertReplyUseCase {
    val insertedReplies = mutableListOf<Reply>()

    override suspend fun upsertReply(reply: Reply): Long {
        insertedReplies += reply

        return reply.id
    }
}
