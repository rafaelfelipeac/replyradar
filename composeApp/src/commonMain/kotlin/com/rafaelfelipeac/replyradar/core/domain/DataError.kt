package com.rafaelfelipeac.replyradar.core.domain

sealed interface DataError : Error {
    enum class Remote : DataError

    enum class Local : DataError {
        DISK_FULL,
        UNKNOWN
    }
}