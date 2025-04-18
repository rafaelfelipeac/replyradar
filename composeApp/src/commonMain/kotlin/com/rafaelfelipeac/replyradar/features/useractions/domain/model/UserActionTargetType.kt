package com.rafaelfelipeac.replyradar.features.useractions.domain.model

sealed class UserActionTargetType(val value: String) {
    data object Message : UserActionTargetType(MESSAGE)
    data object Theme : UserActionTargetType(THEME)
    data object Language : UserActionTargetType(LANGUAGE)
    data object Feedback : UserActionTargetType(FEEDBACK)
    data object Rate : UserActionTargetType(RATE)

    companion object {
        fun fromValue(value: String?): UserActionTargetType {
            return when (value) {
                THEME -> Theme
                LANGUAGE -> Language
                FEEDBACK -> Feedback
                RATE -> Rate
                else -> Message
            }
        }
    }
}

private const val MESSAGE = "MESSAGE"
private const val THEME = "THEME"
private const val LANGUAGE = "LANGUAGE"
private const val FEEDBACK = "FEEDBACK"
private const val RATE = "RATE"
