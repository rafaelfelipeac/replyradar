package com.rafaelfelipeac.replyradar.features.reply.domain.model

data class Reply(
    val id: Long = 0,
    val name: String,
    val subject: String,
    val isResolved: Boolean = false
)
