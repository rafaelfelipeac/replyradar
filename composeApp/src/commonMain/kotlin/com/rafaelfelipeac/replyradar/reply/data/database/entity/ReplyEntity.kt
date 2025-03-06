package com.rafaelfelipeac.replyradar.reply.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReplyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val isResolved: Boolean
)
