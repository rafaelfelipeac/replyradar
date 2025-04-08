package com.rafaelfelipeac.replyradar.features.useractions.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserActionDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(userActionEntity: UserActionEntity)

    @Query("SELECT * FROM user_actions")
    fun getUserActions(): Flow<List<UserActionEntity>>
}
