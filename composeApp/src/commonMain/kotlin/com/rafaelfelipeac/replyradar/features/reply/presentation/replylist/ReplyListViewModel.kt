package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleArchiveReplyUseCase
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
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Message
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Archive
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Create
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Delete
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Edit
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Reopen
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Resolve
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Restore
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReplyListViewModel(
    private val upsertReplyUseCase: UpsertReplyUseCase,
    private val toggleResolveReplyUseCase: ToggleResolveReplyUseCase,
    private val toggleArchiveReplyUseCase: ToggleArchiveReplyUseCase,
    private val deleteReplyUseCase: DeleteReplyUseCase,
    private val getRepliesUseCase: GetRepliesUseCase,
    private val logUserActionUseCase: LogUserActionUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    private val _state = MutableStateFlow(ReplyListState())
    val state = _state
        .onStart {
            getReplies()
            observeResolvedReplies()
            observeArchivedReplies()
        }
        .stateIn(
            CoroutineScope(dispatcher + SupervisorJob()),
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
            is OnAddReply -> onUpsertReply(reply = intent.reply, actionType = Create)
            is OnEditReply -> onUpsertReply(reply = intent.reply, actionType = Edit)
            is OnDeleteReply -> deleteReply(reply = intent.reply)
            is OnToggleArchive -> onToggleArchiveReply(reply = intent.reply)
            is OnToggleResolve -> onToggleResolveReply(reply = intent.reply)
            OnDismissBottomSheet -> dismissBottomSheet()
        }

        dismissBottomSheet()
    }

    private fun getReplies() = viewModelScope.launch {
        updateState { copy(isLoading = true) }

        getRepliesUseCase
            .getReplies()
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

    private fun observeArchivedReplies() = viewModelScope.launch {
        getRepliesUseCase
            .getReplies(isArchived = true)
            .collect { archivedReplies ->
                updateState { copy(archivedReplies = archivedReplies) }
            }
    }

    private fun onUpsertReply(reply: Reply, actionType: UserActionType) = viewModelScope.launch {
        val replyId = upsertReplyUseCase.upsertReply(reply)

        logUserAction(actionType = actionType, targetId = replyId)
    }

    private fun onToggleArchiveReply(reply: Reply) = viewModelScope.launch {
        val isArchived = toggleArchiveReplyUseCase.toggleArchiveReply(reply)

        logUserAction(actionType = if (isArchived) Archive else Restore, targetId = reply.id)
    }

    private fun onToggleResolveReply(reply: Reply) = viewModelScope.launch {
        val isResolved = toggleResolveReplyUseCase.toggleResolveReply(reply)

        logUserAction(actionType = if (isResolved) Resolve else Reopen, targetId = reply.id)
    }

    private fun deleteReply(reply: Reply) = viewModelScope.launch {
        deleteReplyUseCase.deleteReply(reply)

        logUserAction(actionType = Delete, targetId = reply.id)
    }

    private fun dismissBottomSheet() {
        updateState { copy(replyBottomSheetState = null) }
    }

    private fun updateState(update: ReplyListState.() -> ReplyListState) {
        _state.update { it.update() }
    }

    private suspend fun logUserAction(actionType: UserActionType, targetId: Long) {
        logUserActionUseCase.logUserAction(
            actionType = actionType,
            targetType = Message,
            targetId = targetId
        )
    }

    companion object {
        private const val STOP_TIMEOUT = 5_000L
    }
}
