package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaelfelipeac.replyradar.core.reminder.ReminderScheduler
import com.rafaelfelipeac.replyradar.core.reminder.model.NotificationReminderParams
import com.rafaelfelipeac.replyradar.core.util.AppConstants.ARCHIVED_INDEX
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INITIAL_DATE
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INITIAL_ID
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INVALID_ID
import com.rafaelfelipeac.replyradar.core.util.AppConstants.ON_THE_RADAR_INDEX
import com.rafaelfelipeac.replyradar.core.util.AppConstants.RESOLVED_INDEX
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleArchiveReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.GoToSettings
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.RequestNotificationPermission
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.ScheduleReminder
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Archived
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Removed
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Reopened
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Resolved
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Unarchived
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent.OnCheckNotificationPermission
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent.OnGoToSettings
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent.OnRequestNotificationPermission
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent.OnScheduleReminder
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnAddOrEditReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDeleteReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDismissBottomSheet
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleArchive
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleResolve
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnAddReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnOpenReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnPendingReplyId
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyToggle
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
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.OpenedNotification
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Reopen
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Resolve
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Scheduled
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Unarchive
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@Suppress("TooGenericExceptionCaught", "SwallowedException")
class ReplyListViewModel(
    private val upsertReplyUseCase: UpsertReplyUseCase,
    private val toggleResolveReplyUseCase: ToggleResolveReplyUseCase,
    private val toggleArchiveReplyUseCase: ToggleArchiveReplyUseCase,
    private val deleteReplyUseCase: DeleteReplyUseCase,
    private val getRepliesUseCase: GetRepliesUseCase,
    private val logUserActionUseCase: LogUserActionUseCase,
    private val reminderScheduler: ReminderScheduler,
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

    private val _effect = MutableSharedFlow<ReplyListEffect>()
    val effect = _effect

    private var pendingReplyId: Long? = INVALID_ID

    fun onIntent(intent: ReplyListScreenIntent) {
        when (intent) {
            is ReplyListIntent -> handleReplyListIntent(intent)
            is ReplyBottomSheetIntent -> handleReplyBottomSheetIntent(intent)
            is NotificationPermissionIntent -> handleNotificationPermissionIntent(intent)
        }
    }

    private fun handleReplyListIntent(intent: ReplyListIntent) {
        when (intent) {
            is OnPendingReplyId -> {
                pendingReplyId = intent.pendingReplyId
            }

            OnAddReplyClick -> {
                updateState {
                    copy(
                        replyBottomSheetState = ReplyBottomSheetState(
                            replyBottomSheetMode = CREATE
                        )
                    )
                }
            }

            is OnOpenReply -> onOpenReply(intent.reply)

            is OnReplyToggle -> {
                onToggleResolveReply(reply = intent.reply)
            }

            is OnTabSelected -> onTabSelected(intent.index)
        }
    }

    private fun handleReplyBottomSheetIntent(intent: ReplyBottomSheetIntent) {
        when (intent) {
            is OnAddOrEditReply -> onUpsertReply(reply = intent.reply)
            is OnDeleteReply -> deleteReply(reply = intent.reply)
            is OnToggleArchive -> onToggleArchiveReply(reply = intent.reply)
            is OnToggleResolve -> onToggleResolveReply(reply = intent.reply)
            OnDismissBottomSheet -> dismissBottomSheet()
        }

        dismissBottomSheet()
    }

    private fun handleNotificationPermissionIntent(intent: NotificationPermissionIntent) {
        when (intent) {
            is OnCheckNotificationPermission -> checkNotificationPermission(intent.reply)
            OnGoToSettings -> goToSettings()
            OnRequestNotificationPermission -> requestNotificationPermission()
            is OnScheduleReminder -> onScheduleReminder(intent)
        }
    }

    private fun onOpenReply(reply: Reply) {
        updateState {
            copy(
                replyBottomSheetState = ReplyBottomSheetState(
                    replyBottomSheetMode = EDIT,
                    reply = reply
                )
            )
        }
    }

    private fun getReplies() = viewModelScope.launch {
        updateState { copy(isLoading = true) }

        try {
            getRepliesUseCase
                .getReplies()
                .collect { replies ->
                    updateState {
                        copy(
                            isLoading = false,
                            replies = replies
                        )
                    }

                    checkPendingReplyId(
                        replies = replies,
                        onTabSelection = { onTabSelected(ON_THE_RADAR_INDEX) }
                    )
                }
        } catch (e: Exception) {
            updateState {
                copy(
                    isLoading = false,
                    errorMessage = ERROR_GET_REPLIES
                )
            }
        }
    }

    private fun observeResolvedReplies() = viewModelScope.launch {
        try {
            getRepliesUseCase
                .getReplies(isResolved = true)
                .collect { resolvedReplies ->
                    updateState { copy(resolvedReplies = resolvedReplies) }

                    checkPendingReplyId(
                        replies = resolvedReplies,
                        onTabSelection = { onTabSelected(RESOLVED_INDEX) }
                    )
                }
        } catch (_: Exception) {
        }
    }

    private fun observeArchivedReplies() = viewModelScope.launch {
        try {
            getRepliesUseCase
                .getReplies(isArchived = true)
                .collect { archivedReplies ->
                    updateState { copy(archivedReplies = archivedReplies) }

                    checkPendingReplyId(
                        replies = archivedReplies,
                        onTabSelection = { onTabSelected(ARCHIVED_INDEX) }
                    )
                }
        } catch (_: Exception) {
        }
    }

    private fun onUpsertReply(reply: Reply) = viewModelScope.launch {
        val actionType = if (reply.id == INITIAL_ID) Create else Edit
        val replyId = upsertReplyUseCase.upsertReply(reply)

        logUserAction(actionType = actionType, targetId = replyId)

        if (reply.reminderAt != INITIAL_DATE) {
            _effect.emit(ScheduleReminder(reply, replyId))
        }
    }

    private fun onToggleArchiveReply(reply: Reply) = viewModelScope.launch {
        val isArchived = toggleArchiveReplyUseCase.toggleArchiveReply(reply)

        logUserAction(actionType = if (isArchived) Archive else Unarchive, targetId = reply.id)

        _effect.emit(if (isArchived) Archived else Unarchived)
    }

    private fun onToggleResolveReply(reply: Reply) = viewModelScope.launch {
        val isResolved = toggleResolveReplyUseCase.toggleResolveReply(reply)

        logUserAction(actionType = if (isResolved) Resolve else Reopen, targetId = reply.id)

        _effect.emit(if (isResolved) Resolved else Reopened)
    }

    private fun deleteReply(reply: Reply) = viewModelScope.launch {
        deleteReplyUseCase.deleteReply(reply)

        logUserAction(actionType = Delete, targetId = reply.id)

        _effect.emit(Removed)
    }

    private fun dismissBottomSheet() {
        updateState { copy(replyBottomSheetState = null) }
    }

    private fun requestNotificationPermission() = viewModelScope.launch {
        _effect.emit(RequestNotificationPermission)
    }

    private fun checkNotificationPermission(reply: Reply) = viewModelScope.launch {
        _effect.emit(ReplyListEffect.CheckNotificationPermission(reply))
    }

    private fun goToSettings() = viewModelScope.launch {
        _effect.emit(GoToSettings)
    }

    private fun updateState(update: ReplyListState.() -> ReplyListState) {
        _state.update { it.update() }
    }

    private fun onScheduleReminder(intent: OnScheduleReminder) = viewModelScope.launch {
        with(intent.reply) {
            reminderScheduler.scheduleReminder(
                reminderAtMillis = reminderAt,
                notificationReminderParams = NotificationReminderParams(
                    replyId = id,
                    notificationTitle = intent.notificationTitle,
                    notificationContent = intent.notificationContent
                )
            )
        }

        logUserAction(
            actionType = Scheduled,
            targetId = intent.replyId
        )
    }

    private suspend fun logUserAction(actionType: UserActionType, targetId: Long) {
        logUserActionUseCase.logUserAction(
            actionType = actionType,
            targetType = Message,
            targetId = targetId
        )
    }

    private fun checkPendingReplyId(replies: List<Reply>, onTabSelection: () -> Unit) = viewModelScope.launch {
        if (pendingReplyId != INVALID_ID) {
            val reply = replies.find { it.id == pendingReplyId }

            if (reply != null) {
                onTabSelection()
                onOpenReply(reply)

                pendingReplyId?.let { replyId ->
                    logUserAction(
                        actionType = OpenedNotification,
                        targetId = replyId
                    )
                }

                pendingReplyId = null
            }
        }
    }

    private fun onTabSelected(index: Int) {
        updateState {
            copy(selectedTabIndex = index)
        }
    }

    companion object {
        private const val STOP_TIMEOUT = 5_000L
        const val ERROR_GET_REPLIES = "error_get_replies"
    }
}
