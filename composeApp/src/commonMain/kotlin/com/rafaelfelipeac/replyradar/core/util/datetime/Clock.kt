package com.rafaelfelipeac.replyradar.core.util.datetime

interface Clock {
    fun now(): Long
}

expect fun getClock(): Clock
