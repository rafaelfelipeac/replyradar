package com.rafaelfelipeac.replyradar.reply.data.repository

import androidx.sqlite.SQLiteException
import com.rafaelfelipeac.replyradar.core.domain.DataError
import com.rafaelfelipeac.replyradar.core.domain.EmptyResult
import com.rafaelfelipeac.replyradar.reply.data.database.ReplyDao
import com.rafaelfelipeac.replyradar.reply.data.mappers.toReply
import com.rafaelfelipeac.replyradar.reply.data.mappers.toReplyEntity
import com.rafaelfelipeac.replyradar.reply.domain.Reply
import com.rafaelfelipeac.replyradar.reply.domain.ReplyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import com.rafaelfelipeac.replyradar.core.domain.Result

class ReplyRepositoryImpl(
    private val replyDao: ReplyDao
): ReplyRepository {
    override suspend fun getReplies(): Flow<List<Reply>> {
        val mockReplies = (1..100).map {
            Reply(
                id = it.toString(),
                title = "Reply $it",
                description = "Description $it"
            )
        }

        return flowOf(mockReplies)

//        return replyDao
//            .getFavoriteReplies()
//            .map { replyEntities ->
//                replyEntities.map { it.toReply() }
//            }
    }

    override fun getFavoriteReplies(): Flow<List<Reply>> {
        return replyDao
            .getFavoriteReplies()
            .map { replyEntities ->
                replyEntities.map { it.toReply() }
            }
    }

    override fun isReplyFavorite(id: String): Flow<Boolean> {
        return replyDao
            .getFavoriteReplies()
            .map { replyEntities ->
                replyEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavorite(reply: Reply): EmptyResult<DataError.Local> {
        return try {
            replyDao.upsert(reply.toReplyEntity())
            Result.Success(Unit)
        } catch(e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorites(id: String) {
        replyDao.deleteFavoriteReply(id)
    }
}