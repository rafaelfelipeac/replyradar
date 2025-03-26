package com.rafaelfelipeac.replyradar.fakes.reply.domain

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCase

class FakeToggleResolveReplyUseCase : ToggleResolveReplyUseCase {
    val toggledReplies = mutableListOf<Reply>()

    override suspend fun toggleResolveReply(reply: Reply): Boolean {
        toggledReplies += reply

        return !reply.isResolved
    }
}
