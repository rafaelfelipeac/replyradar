package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply

sealed interface ReplyListAction {

    data object OnAddReplyClick : ReplyListAction

    data class OnReplyClick(val reply: Reply): ReplyListAction

    data class OnTabSelected(val index: Int): ReplyListAction

    data class OnAddReply(val reply: Reply) : ReplyListAction

    data class OnEditReply(val reply: Reply) : ReplyListAction

    data class OnDeleteReply(val reply: Reply): ReplyListAction

    data object OnDismissBottomSheet : ReplyListAction

    data class OnToggleResolve(val reply: Reply): ReplyListAction
}