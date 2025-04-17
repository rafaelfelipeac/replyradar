package com.rafaelfelipeac.replyradar.features.reply.data.repository

import com.rafaelfelipeac.replyradar.core.util.Clock
import com.rafaelfelipeac.replyradar.features.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.features.reply.data.mapper.toReply
import com.rafaelfelipeac.replyradar.features.reply.data.mapper.toReplyEntity
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ReplyRepositoryImpl(
    private val replyDao: ReplyDao,
    private val clock: Clock
) : ReplyRepository {

    override suspend fun upsertReply(reply: Reply): Long {
        val now = clock.now()
        val replyEntity = reply.toReplyEntity()

        val entityToSave = if (reply.id == 0L) {
            replyEntity.copy(createdAt = now, updatedAt = now)
        } else {
            replyEntity.copy(updatedAt = now)
        }

        return replyDao.insert(entityToSave)
    }

    override suspend fun toggleReplyResolve(reply: Reply) {
        replyDao.update(
            reply.toReplyEntity().copy(
                resolvedAt = clock.now(),
                isResolved = !reply.isResolved
            )
        )
    }

    override suspend fun toggleReplyArchive(reply: Reply) {
        replyDao.update(
            reply.toReplyEntity().copy(
                archivedAt = clock.now(),
                isArchived = !reply.isArchived
            )
        )
    }

    override suspend fun deleteReply(reply: Reply) {
        replyDao.deleteReply(reply.id)
    }

    override suspend fun getReplies(isResolved: Boolean, isArchived: Boolean): Flow<List<Reply>> {
        val sourceFlow = when {
            isResolved -> replyDao.getResolvedReplies()
            isArchived -> replyDao.getArchivedReplies()
            else -> replyDao.getActiveReplies()
        }

        return sourceFlow.map { it.map { entity -> entity.toReply() } }
    }
}
