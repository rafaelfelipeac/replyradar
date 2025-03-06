package com.rafaelfelipeac.replyradar.reply.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rafaelfelipeac.replyradar.reply.data.database.entity.ReplyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReplyDao {

    @Upsert
    suspend fun upsert(reply: ReplyEntity)

    @Query("SELECT * FROM ReplyEntity where isResolved == :isResolved")
    fun getReplies(isResolved: Boolean): Flow<List<ReplyEntity>>

    @Query("DELETE FROM ReplyEntity WHERE id = :id")
    suspend fun deleteReply(id: Int)
}