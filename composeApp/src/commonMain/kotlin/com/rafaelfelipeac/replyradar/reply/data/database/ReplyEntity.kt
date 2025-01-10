package com.rafaelfelipeac.replyradar.reply.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReplyEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val title: String,
    val description: String,
)
