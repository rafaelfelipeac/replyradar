package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

sealed interface ReplyListEffect {

    data class CheckNotificationPermission(val reply: Reply): ReplyListEffect

    data object RequestNotificationPermission: ReplyListEffect

    data object GoToSettings : ReplyListEffect

    sealed interface SnackbarState : ReplyListEffect {
        data object Resolved : SnackbarState
        data object Reopened : SnackbarState
        data object Removed : SnackbarState
        data object Archived : SnackbarState
        data object Unarchived : SnackbarState
    }

    data class ScheduleReminder(val reply: Reply) : ReplyListEffect
}
