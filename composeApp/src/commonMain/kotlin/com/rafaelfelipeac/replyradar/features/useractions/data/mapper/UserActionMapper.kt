package com.rafaelfelipeac.replyradar.features.useractions.data.mapper

import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType

fun UserActionEntity.toUserAction(targetName: String?) = UserAction(
    id = id,
    actionType = UserActionType.fromValue(actionType),
    targetType = UserActionTargetType.fromValue(targetType),
    targetName = targetName,
    createdAt = createdAt
)
