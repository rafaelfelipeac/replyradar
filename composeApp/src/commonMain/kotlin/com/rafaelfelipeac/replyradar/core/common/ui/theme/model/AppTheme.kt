package com.rafaelfelipeac.replyradar.core.common.ui.theme.model

enum class AppTheme {
    LIGHT,
    DARK,
    SYSTEM;

    companion object {
        fun fromString(value: String): AppTheme {
            return entries.firstOrNull { it.name == value } ?: SYSTEM
        }
    }
}
