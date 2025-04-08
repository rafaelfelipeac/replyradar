package com.rafaelfelipeac.replyradar

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType

const val now = 123456789L
const val targetId = 99L

const val CREATE = "CREATE"
const val EDIT = "EDIT"
const val ARCHIVE = "ARCHIVE"
const val UNARCHIVE = "UNARCHIVE"
const val DELETE = "DELETE"
const val RESOLVE = "RESOLVE"
const val REOPEN = "REOPEN"

const val dropFirst = 1

val sampleUserAction = UserAction(
    id = 1L,
    actionType = UserActionType.Create,
    targetType = UserActionTargetType.Message,
    targetName = "TargetName",
    createdAt = 123456789L
)
