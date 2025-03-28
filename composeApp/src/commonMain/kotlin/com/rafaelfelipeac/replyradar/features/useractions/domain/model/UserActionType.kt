package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionType(val value: String) {
    data object Create : UserActionType(CREATE)
    data object Edit : UserActionType(EDIT)
    data object Archive : UserActionType(ARCHIVE)
    data object Restore : UserActionType(RESTORE)
    data object Delete : UserActionType(DELETE)
    data object Resolve : UserActionType(RESOLVE)
    data object Reopen : UserActionType(REOPEN)
}

private const val CREATE = "CREATE"
private const val EDIT = "EDIT"
private const val ARCHIVE = "ARCHIVE"
private const val RESTORE = "RESTORE"
private const val DELETE = "DELETE"
private const val RESOLVE = "RESOLVE"
private const val REOPEN = "REOPEN"
