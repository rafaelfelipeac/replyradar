package com.rafaelfelipeac.replyradar.features.useractions.data.database.dao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserActionDao {

    @Query(
        "INSERT INTO user_actions (actionType, targetType, targetId, timestamp) " +
                "VALUES (:actionType, :targetType, :targetId, strftime('%s','now') * $TIME_CONSTANT)"
    )
    suspend fun insert(actionType: String, targetType: String?, targetId: Long?)

    companion object {
        private const val TIME_CONSTANT = 1000
    }
}
