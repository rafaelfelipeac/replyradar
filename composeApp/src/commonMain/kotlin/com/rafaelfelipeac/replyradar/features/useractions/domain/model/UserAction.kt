package com.rafaelfelipeac.replyradar.features.useractions.domain.model

data class UserAction(
    val id: Long,
    val actionType: UserActionType,
    val targetType: UserActionTargetType,
    val targetName: String?,
    val createdAt: Long
)
