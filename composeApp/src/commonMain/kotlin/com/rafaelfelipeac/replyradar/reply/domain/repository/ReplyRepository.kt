package com.rafaelfelipeac.replyradar.reply.domain.repository

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import kotlinx.coroutines.flow.Flow

interface ReplyRepository {
    suspend fun getReplies(isResolved: Boolean): Flow<List<Reply>>
    suspend fun toggleReplyResolve(reply: Reply)
    suspend fun upsertReply(reply: Reply)
    suspend fun deleteReply(reply: Reply)
}