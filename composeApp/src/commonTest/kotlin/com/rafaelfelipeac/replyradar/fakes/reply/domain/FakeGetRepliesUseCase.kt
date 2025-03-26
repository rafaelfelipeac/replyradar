package com.rafaelfelipeac.replyradar.fakes.reply.domain

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

class FakeGetRepliesUseCase : GetRepliesUseCase {
    override suspend fun getReplies(isResolved: Boolean, isArchived: Boolean): Flow<List<Reply>> {
        return MutableSharedFlow()
    }
}
