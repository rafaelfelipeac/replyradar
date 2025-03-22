package com.rafaelfelipeac.replyradar.features.reply.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReplyDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(reply: ReplyEntity): Long

    @Update
    suspend fun update(reply: ReplyEntity): Int

    @Query("DELETE FROM replies WHERE id = :id")
    suspend fun deleteReply(id: Long)

    @Query("SELECT * FROM replies WHERE isResolved = 0 AND isArchived = 0")
    fun getActiveReplies(): Flow<List<ReplyEntity>>

    @Query("SELECT * FROM replies WHERE isResolved = 1")
    fun getResolvedReplies(): Flow<List<ReplyEntity>>

    @Query("SELECT * FROM replies WHERE isArchived = 1")
    fun getArchivedReplies(): Flow<List<ReplyEntity>>
}
