package com.rafaelfelipeac.replyradar.features.reply.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "replies")
data class ReplyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val subject: String,
    val isResolved: Boolean
)
