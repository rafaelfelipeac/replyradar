package com.rafaelfelipeac.replyradar.reply.domain.model

data class Reply(
    val id: Int = 0,
    val name: String,
    val subject: String,
    val isResolved: Boolean = false
)
