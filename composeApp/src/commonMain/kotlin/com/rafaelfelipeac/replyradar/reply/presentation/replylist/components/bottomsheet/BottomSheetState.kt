package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet

import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode.CREATE

data class BottomSheetState(
    val mode: BottomSheetMode = CREATE,
    val reply: Reply? = null
)

enum class BottomSheetMode {
    CREATE,
    EDIT
}
