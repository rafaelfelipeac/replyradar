package com.rafaelfelipeac.replyradar.fakes.reply.domain

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleArchiveReplyUseCase

class FakeToggleArchiveReplyUseCase : ToggleArchiveReplyUseCase {
    val toggledReplies = mutableListOf<Reply>()

    override suspend fun toggleArchiveReply(reply: Reply): Boolean {
        toggledReplies += reply

        return !reply.isArchived
    }
}