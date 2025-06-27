package com.rafaelfelipeac.replyradar.core.datetime

actual fun getClock(): Clock = object : Clock {
    override fun now(): Long = System.currentTimeMillis()
}
