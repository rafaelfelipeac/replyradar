package com.rafaelfelipeac.replyradar.features.reply.domain.model

data class Reply(
    val id: Long = 0,
    val name: String,
    val subject: String,
    val isResolved: Boolean = false,
    val isArchived: Boolean = false,
    val createdAt: Long = 0,
    val updatedAt: Long = 0,
    val resolvedAt: Long = 0,
    val archivedAt: Long = 0
)
