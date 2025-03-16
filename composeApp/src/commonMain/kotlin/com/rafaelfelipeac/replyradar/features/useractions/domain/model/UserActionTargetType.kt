package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionTargetType(val value: String) {
    data object Message : UserActionTargetType(MESSAGE)
}

private const val MESSAGE = "MESSAGE"
