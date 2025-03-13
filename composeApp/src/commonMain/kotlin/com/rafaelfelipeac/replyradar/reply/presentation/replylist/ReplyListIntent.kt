package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply

sealed interface ReplyListScreenIntent {

    sealed interface ReplyListIntent : ReplyListScreenIntent {
        data object OnAddReplyClick : ReplyListIntent
        data class OnTabSelected(val index: Int) : ReplyListIntent
        data class OnReplyClick(val reply: Reply) : ReplyListIntent
    }

    sealed interface ReplyBottomSheetIntent : ReplyListScreenIntent {
        data class OnAddReply(val reply: Reply) : ReplyBottomSheetIntent
        data class OnEditReply(val reply: Reply) : ReplyBottomSheetIntent
        data class OnDeleteReply(val reply: Reply) : ReplyBottomSheetIntent
        data class OnToggleResolve(val reply: Reply) : ReplyBottomSheetIntent
        data object OnDismissBottomSheet : ReplyBottomSheetIntent
    }
}
