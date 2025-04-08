package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionType(val value: String) {
    data object Create : UserActionType(CREATE)
    data object Edit : UserActionType(EDIT)
    data object Resolve : UserActionType(RESOLVE)
    data object Reopen : UserActionType(REOPEN)
    data object Archive : UserActionType(ARCHIVE)
    data object Unarchive : UserActionType(UNARCHIVE)
    data object Delete : UserActionType(DELETE)

    companion object {
        fun fromValue(value: String): UserActionType {
            return when (value) {
                CREATE -> Create
                EDIT -> Edit
                RESOLVE -> Resolve
                REOPEN -> Reopen
                ARCHIVE -> Archive
                DELETE -> Delete
                else -> Unarchive
            }
        }
    }
}

private const val CREATE = "CREATE"
private const val EDIT = "EDIT"
private const val RESOLVE = "RESOLVE"
private const val REOPEN = "REOPEN"
private const val ARCHIVE = "ARCHIVE"
private const val UNARCHIVE = "UNARCHIVE"
private const val DELETE = "DELETE"
