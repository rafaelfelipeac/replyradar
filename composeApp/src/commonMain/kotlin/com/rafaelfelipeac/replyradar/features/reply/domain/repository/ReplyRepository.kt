package com.rafaelfelipeac.replyradar.features.reply.domain.repository

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import kotlinx.coroutines.flow.Flow

interface ReplyRepository {
    suspend fun upsertReply(reply: Reply) : Long
    suspend fun deleteReply(reply: Reply)
    suspend fun toggleReplyResolve(reply: Reply)
    suspend fun getReplies(isResolved: Boolean): Flow<List<Reply>>
}
