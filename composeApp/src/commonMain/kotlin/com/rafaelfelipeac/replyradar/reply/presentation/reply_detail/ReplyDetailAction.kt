package com.rafaelfelipeac.replyradar.reply.presentation.reply_detail

import com.rafaelfelipeac.replyradar.reply.domain.Reply

sealed interface ReplyDetailAction {
    data object OnBackClick: ReplyDetailAction
    data object OnFavoriteClick: ReplyDetailAction
    data class OnSelectedReplyChange(val reply: Reply): ReplyDetailAction
}