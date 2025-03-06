package com.rafaelfelipeac.replyradar.reply.domain.model

data class Reply(
    val id: Int = 0,
    val title: String,
    val description: String = "",
    val isResolved: Boolean = false
)
