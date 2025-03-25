package com.rafaelfelipeac.replyradar.fakes.reply.domain

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCase

class FakeDeleteReplyUseCase : DeleteReplyUseCase {
    val deletedReplies = mutableListOf<Reply>()

    override suspend fun deleteReply(reply: Reply) {
        deletedReplies += reply
    }
}
