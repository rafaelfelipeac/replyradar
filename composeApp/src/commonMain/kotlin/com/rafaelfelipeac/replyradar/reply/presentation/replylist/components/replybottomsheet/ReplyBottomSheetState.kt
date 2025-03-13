package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.CREATE

data class ReplyBottomSheetState(
    val replyBottomSheetMode: ReplyBottomSheetMode = CREATE,
    val reply: Reply? = null
)
