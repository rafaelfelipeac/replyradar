package com.rafaelfelipeac.replyradar.features.reply.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "replies")
data class ReplyEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val subject: String,
    val isResolved: Boolean = false,
    val isArchived: Boolean = false,
    val createdAt: Long = 0L,
    val updatedAt: Long = 0L,
    val resolvedAt: Long = 0L,
    val archivedAt: Long = 0L
)
