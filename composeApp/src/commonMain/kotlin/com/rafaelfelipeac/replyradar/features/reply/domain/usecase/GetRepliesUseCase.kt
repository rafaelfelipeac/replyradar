package com.rafaelfelipeac.replyradar.features.reply.domain.usecase

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository
import kotlinx.coroutines.flow.Flow

interface GetRepliesUseCase {
    suspend fun getReplies(
        isResolved: Boolean = false,
        isArchived: Boolean = false
    ): Flow<List<Reply>>
}

class GetRepliesUseCaseImpl(
    private val replyRepository: ReplyRepository
) : GetRepliesUseCase {

    override suspend fun getReplies(isResolved: Boolean, isArchived: Boolean): Flow<List<Reply>> {
        return replyRepository.getReplies(isResolved = isResolved, isArchived = isArchived)
    }
}
