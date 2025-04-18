package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

sealed interface SnackbarState {
    data object Resolved : SnackbarState
    data object Reopened : SnackbarState
    data object Removed : SnackbarState
    data object Archived : SnackbarState
    data object Unarchived : SnackbarState
}
