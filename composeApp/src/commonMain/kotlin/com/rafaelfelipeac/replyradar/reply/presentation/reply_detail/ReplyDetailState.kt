package com.rafaelfelipeac.replyradar.reply.presentation.reply_detail

import com.rafaelfelipeac.replyradar.reply.domain.Reply

data class ReplyDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val reply: Reply? = null
)
