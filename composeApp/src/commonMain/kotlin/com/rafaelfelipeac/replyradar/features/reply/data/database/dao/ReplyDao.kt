package com.rafaelfelipeac.replyradar.features.reply.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReplyDao {

    @Upsert
    suspend fun upsert(reply: ReplyEntity)

    @Query("DELETE FROM replies WHERE id = :id")
    suspend fun deleteReply(id: Long)

    @Query("SELECT * FROM replies where isResolved == :isResolved")
    fun getReplies(isResolved: Boolean): Flow<List<ReplyEntity>>
}
