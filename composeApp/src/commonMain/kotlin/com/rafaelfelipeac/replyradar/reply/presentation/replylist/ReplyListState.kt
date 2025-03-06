package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetState

data class ReplyListState(
    val replies: List<Reply> = emptyList(),
    val resolvedReplies: List<Reply> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val selectedTabIndex: Int = 0,
    val bottomSheetState: BottomSheetState? = null
)