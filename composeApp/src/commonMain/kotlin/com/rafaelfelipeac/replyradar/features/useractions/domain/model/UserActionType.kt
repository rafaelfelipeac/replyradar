package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionType(val value: String) {
    data object Create : UserActionType(CREATE)
    data object Edit : UserActionType(EDIT)
    data object Resolve : UserActionType(RESOLVE)
    data object Reopen : UserActionType(REOPEN)
    data object Archive : UserActionType(ARCHIVE)
    data object Unarchive : UserActionType(UNARCHIVE)
    data object Delete : UserActionType(DELETE)
    data object Scheduled : UserActionType(SCHEDULED)
    data object OpenedNotification : UserActionType(OPENED_NOTIFICATION)
    data object Open : UserActionType(OPEN)

    companion object {
        fun fromValue(value: String): UserActionType {
            return when (value) {
                CREATE -> Create
                EDIT -> Edit
                RESOLVE -> Resolve
                REOPEN -> Reopen
                ARCHIVE -> Archive
                DELETE -> Delete
                OPEN -> Open
                SCHEDULED -> Scheduled
                OPENED_NOTIFICATION -> OpenedNotification
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
private const val OPEN = "OPEN"
private const val SCHEDULED = "SCHEDULED"
private const val OPENED_NOTIFICATION = "OPENED_NOTIFICATION"
