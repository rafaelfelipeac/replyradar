package com.rafaelfelipeac.replyradar.features.reply.domain.model

import com.rafaelfelipeac.replyradar.core.util.AppConstants.INITIAL_DATE

data class Reply(
    val id: Long = 0,
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
