package com.rafaelfelipeac.replyradar.core.util

interface Clock {
    fun now(): Long
}

expect fun getClock(): Clock
