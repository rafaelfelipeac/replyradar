package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

sealed interface ReplyListEffect {

    data object RequestNotificationPermission: ReplyListEffect

    sealed interface SnackbarState : ReplyListEffect {
        data object Resolved : SnackbarState
        data object Reopened : SnackbarState
        data object Removed : SnackbarState
        data object Archived : SnackbarState
        data object Unarchived : SnackbarState
    }
}
