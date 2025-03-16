package com.rafaelfelipeac.replyradar.features.useractions.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_actions")
data class UserActionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val actionType: String,
    val targetType: String?,
    val targetId: Long?,
    val timestamp: Long = 0
)
