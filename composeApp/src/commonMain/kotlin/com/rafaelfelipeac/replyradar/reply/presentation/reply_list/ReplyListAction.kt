package com.rafaelfelipeac.replyradar.reply.presentation.reply_list

import com.rafaelfelipeac.replyradar.reply.domain.Reply

sealed interface ReplyListAction {
    data class OnReplyClick(val reply: Reply):
        ReplyListAction
    data class OnTabSelected(val index: Int):
        ReplyListAction
}