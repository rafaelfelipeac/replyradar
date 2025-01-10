package com.rafaelfelipeac.replyradar.reply.domain

import com.rafaelfelipeac.replyradar.core.domain.DataError
import com.rafaelfelipeac.replyradar.core.domain.EmptyResult
import kotlinx.coroutines.flow.Flow

interface ReplyRepository {
    suspend fun getReplies(): Flow<List<Reply>>

    fun getFavoriteReplies(): Flow<List<Reply>>
    fun isReplyFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(reply: Reply): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(id: String)
}