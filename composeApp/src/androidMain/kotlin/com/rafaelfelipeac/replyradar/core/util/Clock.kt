package com.rafaelfelipeac.replyradar.core.util

actual fun getClock(): Clock = object : Clock {
    override fun now(): Long = System.currentTimeMillis()
}
