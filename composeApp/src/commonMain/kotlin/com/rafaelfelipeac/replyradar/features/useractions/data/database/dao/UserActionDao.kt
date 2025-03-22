package com.rafaelfelipeac.replyradar.features.useractions.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity

@Dao
interface UserActionDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(userActionEntity: UserActionEntity)
}
