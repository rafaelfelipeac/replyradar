package com.rafaelfelipeac.replyradar.core.util.datetime

actual fun getClock(): Clock = object : Clock {
    override fun now(): Long = System.currentTimeMillis()
}
