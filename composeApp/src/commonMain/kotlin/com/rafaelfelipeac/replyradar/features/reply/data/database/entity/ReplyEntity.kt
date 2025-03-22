package com.rafaelfelipeac.replyradar.features.reply.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "replies")
data class ReplyEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val subject: String,
    val isResolved: Boolean,
    val isArchived: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
    val resolvedAt: Long,
    val archivedAt: Long
)
