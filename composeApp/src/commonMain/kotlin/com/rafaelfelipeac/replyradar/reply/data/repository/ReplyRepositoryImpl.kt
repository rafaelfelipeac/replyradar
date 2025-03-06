package com.rafaelfelipeac.replyradar.reply.data.repository

import com.rafaelfelipeac.replyradar.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.reply.data.mapper.toReplyEntity
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.domain.repository.ReplyRepository
import kotlinx.coroutines.flow.Flow
import com.rafaelfelipeac.replyradar.reply.data.mapper.toReply
import kotlinx.coroutines.flow.map

class ReplyRepositoryImpl(
    private val replyDao: ReplyDao
) : ReplyRepository {

    override suspend fun getReplies(isResolved: Boolean): Flow<List<Reply>> {
        return replyDao
            .getReplies(isResolved)
            .map { replyEntities ->
                replyEntities.map { it.toReply() }
            }
    }

    override suspend fun toggleReplyResolve(reply: Reply) { // DC
        replyDao.upsert(reply.toReplyEntity())
    }

    override suspend fun upsertReply(reply: Reply) {
        replyDao.upsert(reply.toReplyEntity())
    }

    override suspend fun deleteReply(reply: Reply) {
        replyDao.deleteReply(reply.id)
    }
}