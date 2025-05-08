package com.rafaelfelipeac.replyradar.features.reply.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rafaelfelipeac.replyradar.core.AppConstants.INITIAL_DATE

@Entity(tableName = "replies")
data class ReplyEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val subject: String,
    val isResolved: Boolean = false,
    val isArchived: Boolean = false,
    val createdAt: Long = INITIAL_DATE,
    val updatedAt: Long = INITIAL_DATE,
    val resolvedAt: Long = INITIAL_DATE,
    val archivedAt: Long = INITIAL_DATE,
    val reminderAt: Long = INITIAL_DATE
)
