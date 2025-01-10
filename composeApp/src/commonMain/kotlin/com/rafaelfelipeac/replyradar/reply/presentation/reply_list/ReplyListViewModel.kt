package com.rafaelfelipeac.replyradar.reply.presentation.reply_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.reply.domain.ReplyRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReplyListViewModel(
    private val replyRepository: ReplyRepository
) : ViewModel() {

    private var observeFavoriteJob: Job? = null

    private val _state = MutableStateFlow(ReplyListState())
    val state = _state
        .onStart {
            getReplies()
            observeFavoriteReplies()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: ReplyListAction) {
        when (action) {
            is ReplyListAction.OnReplyClick -> {

            }

            is ReplyListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }
        }
    }

    private fun observeFavoriteReplies() {
        observeFavoriteJob?.cancel()
        observeFavoriteJob = replyRepository
            .getFavoriteReplies()
            .onEach { favoriteReplies ->
                _state.update {
                    it.copy(
                        favoriteReplies = favoriteReplies
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun getReplies() = viewModelScope.launch {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        replyRepository
            .getReplies()
            .onEach { replies ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        results = replies
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}