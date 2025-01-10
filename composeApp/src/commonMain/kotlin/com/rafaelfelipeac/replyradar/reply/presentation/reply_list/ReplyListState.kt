package com.rafaelfelipeac.replyradar.reply.presentation.reply_list

import com.rafaelfelipeac.replyradar.core.presentation.UiText
import com.rafaelfelipeac.replyradar.reply.domain.Reply

data class ReplyListState(
    val results: List<Reply> = emptyList(),
    val favoriteReplies: List<Reply> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)