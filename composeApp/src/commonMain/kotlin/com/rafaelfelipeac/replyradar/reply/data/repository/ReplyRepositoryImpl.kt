package com.rafaelfelipeac.replyradar.reply.data.repository

import androidx.sqlite.SQLiteException
import com.rafaelfelipeac.replyradar.core.domain.DataError
import com.rafaelfelipeac.replyradar.core.domain.EmptyResult
import com.rafaelfelipeac.replyradar.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.reply.data.mapper.toReplyEntity
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.domain.repository.ReplyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.rafaelfelipeac.replyradar.core.domain.Result
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

    override suspend fun toggleReplyResolve(reply: Reply): EmptyResult<DataError.Local> { // DC
        return try {
            replyDao.upsert(reply.toReplyEntity())
            Result.Success(Unit) // ???
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL) // ?
        }
    }

    override suspend fun upsertReply(reply: Reply) {
        replyDao.upsert(reply.toReplyEntity())
    }

    override suspend fun deleteReply(reply: Reply) {
        replyDao.deleteReply(reply.id)
    }
}