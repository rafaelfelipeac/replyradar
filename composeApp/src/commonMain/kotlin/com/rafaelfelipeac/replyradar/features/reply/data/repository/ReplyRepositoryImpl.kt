package com.rafaelfelipeac.replyradar.features.reply.data.repository

import com.rafaelfelipeac.replyradar.features.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.features.reply.data.mapper.toReplyEntity
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.data.mapper.toReply
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ReplyRepositoryImpl(
    private val replyDao: ReplyDao
) : ReplyRepository {

    override suspend fun upsertReply(reply: Reply) = replyDao.insert(reply.toReplyEntity())

    override suspend fun toggleReplyResolve(reply: Reply) {
        replyDao.update(reply.toReplyEntity())
    }

    override suspend fun deleteReply(reply: Reply) {
        replyDao.deleteReply(reply.id)
    }

    override suspend fun getReplies(isResolved: Boolean): Flow<List<Reply>> {
        return replyDao
            .getReplies(isResolved)
            .map { replyEntities ->
                replyEntities.map { it.toReply() }
            }
    }
}
