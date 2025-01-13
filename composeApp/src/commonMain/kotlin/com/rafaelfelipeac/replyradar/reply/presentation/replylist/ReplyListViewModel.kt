package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.reply.domain.ReplyRepository
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetState
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
            is ReplyListAction.OnAddReplyClick -> {
                _state.update {
                    it.copy(
                        bottomSheetState = BottomSheetState(
                            mode = BottomSheetMode.CREATE
                        )
                    )
                }
            }

            is ReplyListAction.OnReplyClick -> {
                _state.update {
                    it.copy(
                        bottomSheetState = BottomSheetState(
                            mode = BottomSheetMode.EDIT,
                            reply = action.reply
                        )
                    )
                }
            }

            is ReplyListAction.OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }

            is ReplyListAction.OnAddReply -> {
                val x = "add"
            }

            is ReplyListAction.OnEditReply -> {
                val x = "edit"
            }

            ReplyListAction.OnDismissBottomSheet -> {
                _state.value = state.value.copy(
                    bottomSheetState = null
                )
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