package com.rafaelfelipeac.replyradar.core.common.language

enum class AppLanguage {
    ENGLISH,
    PORTUGUESE,
    SYSTEM;

    companion object {
        fun fromString(value: String): AppLanguage {
            return entries.firstOrNull { it.name == value } ?: SYSTEM
        }
    }
}
