package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionTargetType(val value: String) {
    data object Message : UserActionTargetType(MESSAGE)
    data object Theme: UserActionTargetType(THEME)
    data object Language: UserActionTargetType(LANGUAGE)

    companion object {
        fun fromValue(value: String?): UserActionTargetType {
            return when (value) {
                MESSAGE -> Message
                THEME -> Theme
                LANGUAGE -> Language
                else -> throw IllegalArgumentException("Unknown UserActionTargetType value: $value")
            }
        }
    }
}

private const val MESSAGE = "MESSAGE"
private const val THEME = "THEME"
private const val LANGUAGE = "LANGUAGE"
