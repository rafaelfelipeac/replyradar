package com.rafaelfelipeac.replyradar.core.language

enum class AppLanguage {
    ENGLISH,
    PORTUGUESE,
    GERMAN,
    FRENCH,
    SPANISH,
    SYSTEM;

    companion object {
        fun fromString(value: String): AppLanguage {
            return entries.firstOrNull { it.name == value } ?: SYSTEM
        }
    }
}
