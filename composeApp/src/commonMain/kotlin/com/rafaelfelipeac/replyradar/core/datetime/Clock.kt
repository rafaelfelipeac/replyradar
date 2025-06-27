package com.rafaelfelipeac.replyradar.core.datetime

interface Clock {
    fun now(): Long
}

expect fun getClock(): Clock
