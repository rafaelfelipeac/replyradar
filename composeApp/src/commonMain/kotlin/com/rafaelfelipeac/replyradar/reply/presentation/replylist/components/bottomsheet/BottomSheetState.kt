package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet

import com.rafaelfelipeac.replyradar.reply.domain.Reply

data class BottomSheetState(
    val mode: BottomSheetMode = BottomSheetMode.CREATE,
    val reply: Reply? = null
)

enum class BottomSheetMode {
    CREATE,
    EDIT
}
