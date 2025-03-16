package com.rafaelfelipeac.replyradar.features.useractions.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity

@Dao
interface UserActionDao {

    @Insert
    suspend fun insert(userAction: UserActionEntity)
}
