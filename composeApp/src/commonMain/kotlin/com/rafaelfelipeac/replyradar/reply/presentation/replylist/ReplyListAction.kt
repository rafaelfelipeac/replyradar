package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.reply.domain.Reply

sealed interface ReplyListAction {

    data object OnAddReplyClick : ReplyListAction

    data class OnReplyClick(val reply: Reply): ReplyListAction

    data class OnTabSelected(val index: Int): ReplyListAction

    data class OnAddReply(val name: String) : ReplyListAction

    data class OnEditReply(val name: String) : ReplyListAction

    data object OnDismissBottomSheet : ReplyListAction
}