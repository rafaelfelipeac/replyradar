package com.rafaelfelipeac.replyradar.reply.presentation.reply_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.rafaelfelipeac.replyradar.app.Route
import com.rafaelfelipeac.replyradar.reply.domain.ReplyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReplyDetailViewModel(
    private val replyRepository: ReplyRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val replyId = savedStateHandle.toRoute<Route.ReplyDetail>().id

    private val _state = MutableStateFlow(ReplyDetailState())
    val state = _state
        .onStart {
            observeFavoriteStatus()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: ReplyDetailAction) {
        when(action) {
            is ReplyDetailAction.OnSelectedReplyChange -> {
                _state.update { it.copy(
                    reply = action.reply
                ) }
            }
            is ReplyDetailAction.OnFavoriteClick -> {
                viewModelScope.launch {
                    if(state.value.isFavorite) {
                        replyRepository.deleteFromFavorites(replyId)
                    } else {
                        state.value.reply?.let { reply ->
                            replyRepository.markAsFavorite(reply)
                        }
                    }
                }
            }
            else -> Unit
        }
    }

    private fun observeFavoriteStatus() {
        replyRepository
            .isReplyFavorite(replyId)
            .onEach { isFavorite ->
                _state.update { it.copy(
                    isFavorite = isFavorite
                ) }
            }
            .launchIn(viewModelScope)
    }
}