package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionType(val value: String) {
    data object Create : UserActionType(CREATE)
    data object Edit : UserActionType(EDIT)
    data object Delete : UserActionType(DELETE)
    data object Complete : UserActionType(COMPLETE)
}

private const val CREATE = "CREATE"
private const val EDIT = "EDIT"
private const val DELETE = "DELETE"
private const val COMPLETE = "COMPLETE"
