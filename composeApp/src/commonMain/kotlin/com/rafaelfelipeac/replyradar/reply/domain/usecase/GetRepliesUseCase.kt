package com.rafaelfelipeac.replyradar.reply.domain.usecase

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.domain.repository.ReplyRepository
import kotlinx.coroutines.flow.Flow

interface GetRepliesUseCase {
    suspend fun getReplies(isResolved: Boolean): Flow<List<Reply>>
}

class GetRepliesUseCaseImpl(
    private val replyRepository: ReplyRepository
) : GetRepliesUseCase {

    override suspend fun getReplies(isResolved: Boolean): Flow<List<Reply>> {
        return replyRepository.getReplies(isResolved)
    }
}