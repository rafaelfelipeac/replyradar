package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.*
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnAddReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnTabSelected
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReplyListViewModel(
    private val getRepliesUseCase: GetRepliesUseCase,
    private val toggleResolveReplyUseCase: ToggleResolveReplyUseCase,
    private val upsertReplyUseCase: UpsertReplyUseCase,
    private val deleteReplyUseCase: DeleteReplyUseCase,
    private val logUserActionUseCase: LogUserActionUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ReplyListState())
    val state = _state
        .onStart {
            getReplies()
            observeResolvedReplies()
        }
        .stateIn(
            viewModelScope,
            WhileSubscribed(STOP_TIMEOUT),
            _state.value
        )

    fun onIntent(intent: ReplyListScreenIntent) {
        when (intent) {
            is ReplyListIntent -> handleReplyListIntent(intent)
            is ReplyBottomSheetIntent -> handleReplyBottomSheetIntent(intent)
        }
    }

    private fun handleReplyListIntent(intent: ReplyListIntent) {
        when (intent) {
            OnAddReplyClick -> {
                updateState {
                    copy(
                        replyBottomSheetState = ReplyBottomSheetState(
                            replyBottomSheetMode = CREATE
                        )
                    )
                }
            }

            is OnReplyClick -> {
                updateState {
                    copy(
                        replyBottomSheetState = ReplyBottomSheetState(
                            replyBottomSheetMode = EDIT,
                            reply = intent.reply
                        )
                    )
                }
            }

            is OnTabSelected -> {
                updateState {
                    copy(selectedTabIndex = intent.index)
                }
            }
        }
    }

    private fun handleReplyBottomSheetIntent(intent: ReplyBottomSheetIntent) {
        when (intent) {
            is OnAddReply -> onUpsertReply(intent.reply)
            is OnEditReply -> onUpsertReply(intent.reply)
            is OnDeleteReply -> deleteReply(intent.reply)
            is OnToggleResolve -> onToggleResolveReply(intent.reply)
            OnDismissBottomSheet -> dismissBottomSheet()
        }

        dismissBottomSheet()
    }

    private fun getReplies() = viewModelScope.launch {
        updateState { copy(isLoading = true) }

        getRepliesUseCase
            .getReplies(isResolved = false)
            .collect { replies ->
                updateState {
                    copy(
                        isLoading = false,
                        replies = replies
                    )
                }
            }
    }

    private fun observeResolvedReplies() = viewModelScope.launch {
        getRepliesUseCase
            .getReplies(isResolved = true)
            .collect { resolvedReplies ->
                updateState { copy(resolvedReplies = resolvedReplies) }
            }
    }

    private fun onUpsertReply(reply: Reply) = viewModelScope.launch {
        upsertReplyUseCase.upsertReply(reply)
        logUserActionUseCase.logUserAction(reply.name)
    }

    private fun deleteReply(reply: Reply) = viewModelScope.launch {
        deleteReplyUseCase.deleteReply(reply)
    }

    private fun onToggleResolveReply(reply: Reply) = viewModelScope.launch {
        toggleResolveReplyUseCase.toggleResolveReply(reply)
    }

    private fun dismissBottomSheet() {
        updateState { copy(replyBottomSheetState = null) }
    }

    private fun updateState(update: ReplyListState.() -> ReplyListState) {
        _state.update { it.update() }
    }

    companion object {
        private const val STOP_TIMEOUT = 5_000L
    }
}