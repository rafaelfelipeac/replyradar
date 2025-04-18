package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState

data class ReplyListState(
    val replies: List<Reply> = emptyList(),
    val resolvedReplies: List<Reply> = emptyList(),
    val archivedReplies: List<Reply> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val selectedTabIndex: Int = 0,
    val replyBottomSheetState: ReplyBottomSheetState? = null,
    val snackbarState: SnackbarState? = null
)
