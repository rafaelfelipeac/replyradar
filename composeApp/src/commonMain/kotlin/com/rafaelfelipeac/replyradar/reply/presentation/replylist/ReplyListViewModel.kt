package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.domain.usecase.DeleteReplyUseCase
import com.rafaelfelipeac.replyradar.reply.domain.usecase.GetRepliesUseCase
import com.rafaelfelipeac.replyradar.reply.domain.usecase.ToggleResolveReplyUseCase
import com.rafaelfelipeac.replyradar.reply.domain.usecase.UpsertReplyUseCase
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnAddReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnAddReplyClick
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnDeleteReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnDismissBottomSheet
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnEditReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnReplyClick
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnTabSelected
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnToggleResolve
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode.EDIT
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
    private val getRepliesUseCase: GetRepliesUseCase,
    private val toggleResolveReplyUseCase: ToggleResolveReplyUseCase,
    private val upsertReplyUseCase: UpsertReplyUseCase,
    private val deleteReplyUseCase: DeleteReplyUseCase
) : ViewModel() {

    private var observeResolvedJob: Job? = null

    private val _state = MutableStateFlow(ReplyListState())
    val state = _state
        .onStart {
            getReplies()
            observeResolvedReplies()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L), // DC
            _state.value
        )

    fun onAction(action: ReplyListAction) {
        when (action) {
            is OnAddReplyClick -> {
                _state.update {
                    it.copy(
                        bottomSheetState = BottomSheetState(
                            mode = CREATE
                        )
                    )
                }
            }

            is OnReplyClick -> {
                _state.update {
                    it.copy(
                        bottomSheetState = BottomSheetState(
                            mode = EDIT,
                            reply = action.reply
                        )
                    )
                }
            }

            is OnTabSelected -> {
                _state.update {
                    it.copy(selectedTabIndex = action.index)
                }
            }

            is OnAddReply -> {
                onUpsertReply(action.reply)

                _state.value = state.value.copy(
                    bottomSheetState = null
                )
            }

            is OnEditReply -> {
                onUpsertReply(action.reply)

                _state.value = state.value.copy(
                    bottomSheetState = null
                )
            }

            OnDismissBottomSheet -> {
                _state.value = state.value.copy(
                    bottomSheetState = null
                )
            }

            is OnToggleResolve -> {
                onToggleResolveReply(action.reply)

                _state.value = state.value.copy(
                    bottomSheetState = null
                )
            }

            is OnDeleteReply -> {
                deleteReply(action.reply)

                _state.value = state.value.copy(
                    bottomSheetState = null
                )
            }
        }
    }

    private fun getReplies() = viewModelScope.launch {
        _state.update {
            it.copy(
                isLoading = true
            )
        }
        getRepliesUseCase
            .getReplies(isResolved = false)
            .onEach { replies ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        replies = replies
                    )
                }
            }
            .launchIn(viewModelScope) // DC
    }

    private fun observeResolvedReplies() = viewModelScope.launch {
        observeResolvedJob?.cancel()
        observeResolvedJob = getRepliesUseCase
            .getReplies(isResolved = true)
            .onEach { resolvedReplies ->
                _state.update {
                    it.copy(
                        resolvedReplies = resolvedReplies
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    private fun onToggleResolveReply(reply: Reply) = viewModelScope.launch {
        toggleResolveReplyUseCase.toggleResolveReply(reply)
    }

    private fun onUpsertReply(reply: Reply) = viewModelScope.launch {
        upsertReplyUseCase.upsertReply(reply)
    }

    private fun deleteReply(reply: Reply) = viewModelScope.launch {
        deleteReplyUseCase.deleteReply(reply)
    }
}