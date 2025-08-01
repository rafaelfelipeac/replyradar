package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

sealed interface ReplyListScreenIntent {

    sealed interface ReplyListIntent : ReplyListScreenIntent {
        data class OnPendingReplyId(val pendingReplyId: Long?) : ReplyListIntent
        data object OnAddReplyClick : ReplyListIntent
        data class OnTabSelected(val index: Int) : ReplyListIntent
        data class OnOpenReply(val reply: Reply) : ReplyListIntent
        data class OnReplyToggle(val reply: Reply) : ReplyListIntent
    }

    sealed interface ReplyBottomSheetIntent : ReplyListScreenIntent {
        data class OnAddOrEditReply(val reply: Reply) : ReplyBottomSheetIntent
        data class OnDeleteReply(val reply: Reply) : ReplyBottomSheetIntent
        data class OnToggleArchive(val reply: Reply) : ReplyBottomSheetIntent
        data class OnToggleResolve(val reply: Reply) : ReplyBottomSheetIntent
        data object OnDismissBottomSheet : ReplyBottomSheetIntent
    }

    sealed interface NotificationPermissionIntent : ReplyListScreenIntent {
        data object OnRequestNotificationPermission : NotificationPermissionIntent
        data class OnCheckNotificationPermission(val reply: Reply) : NotificationPermissionIntent
        data object OnGoToSettings : NotificationPermissionIntent
        data class OnScheduleReminder(
            val reply: Reply,
            val replyId: Long,
            val notificationTitle: String,
            val notificationContent: String
        ) : NotificationPermissionIntent
    }
}
