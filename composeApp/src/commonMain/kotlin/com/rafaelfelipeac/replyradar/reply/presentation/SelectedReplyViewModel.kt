package com.rafaelfelipeac.replyradar.reply.presentation

import androidx.lifecycle.ViewModel
import com.rafaelfelipeac.replyradar.reply.domain.Reply
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SelectedReplyViewModel: ViewModel() {

    private val _selectedReply = MutableStateFlow<Reply?>(null)
    val selectedReply = _selectedReply.asStateFlow()

    fun onSelectReply(reply: Reply?) {
        _selectedReply.value = reply
    }
}