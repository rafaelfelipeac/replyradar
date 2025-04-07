package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionTargetType(val value: String) {
    data object Message : UserActionTargetType(MESSAGE)

    companion object {
        fun fromValue(value: String?): UserActionTargetType {
            return when (value) {
                MESSAGE -> Message
                else -> throw IllegalArgumentException("Unknown UserActionTargetType value: $value")
            }
        }
    }
}

private const val MESSAGE = "MESSAGE"
