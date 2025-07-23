package com.rafaelfelipeac.replyradar.features.reply.data.repository

import com.rafaelfelipeac.replyradar.core.datetime.getCurrentTimeMillis
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INITIAL_DATE
import com.rafaelfelipeac.replyradar.features.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.features.reply.data.mapper.toReply
import com.rafaelfelipeac.replyradar.features.reply.data.mapper.toReplyEntity
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ReplyRepositoryImpl(
    private val replyDao: ReplyDao
) : ReplyRepository {

    override suspend fun upsertReply(reply: Reply): Long {
        val now = getCurrentTimeMillis()
        val replyEntity = reply.toReplyEntity()

        val entityToSave = if (reply.id == INITIAL_DATE) {
            replyEntity.copy(createdAt = now, updatedAt = now)
        } else {
            replyEntity.copy(updatedAt = now)
        }

        return replyDao.insert(entityToSave)
    }

    override suspend fun toggleReplyResolve(reply: Reply) {
        replyDao.update(
            reply.toReplyEntity().copy(
                resolvedAt = if (!reply.isResolved) getCurrentTimeMillis() else INITIAL_DATE,
                isResolved = !reply.isResolved
            )
        )
    }

    override suspend fun toggleReplyArchive(reply: Reply) {
        replyDao.update(
            reply.toReplyEntity().copy(
                archivedAt = if (!reply.isArchived) getCurrentTimeMillis() else INITIAL_DATE,
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
