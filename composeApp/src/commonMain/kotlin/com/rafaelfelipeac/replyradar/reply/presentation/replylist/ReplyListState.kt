package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.core.presentation.UiText
import com.rafaelfelipeac.replyradar.reply.domain.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetState

data class ReplyListState(
    val results: List<Reply> = emptyList(),
    val favoriteReplies: List<Reply> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null,
    val bottomSheetState: BottomSheetState? = null
)