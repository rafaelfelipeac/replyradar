package com.rafaelfelipeac.replyradar.reply.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ReplyDao {

    @Upsert
    suspend fun upsert(reply: ReplyEntity)

    @Query("SELECT * FROM ReplyEntity")
    fun getFavoriteReplies(): Flow<List<ReplyEntity>>

    @Query("SELECT * FROM ReplyEntity WHERE id = :id")
    suspend fun getFavoriteReply(id: String): ReplyEntity?

    @Query("DELETE FROM ReplyEntity WHERE id = :id")
    suspend fun deleteFavoriteReply(id: String)
}