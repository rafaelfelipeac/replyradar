package com.rafaelfelipeac.replyradar.fakes.core.util

import com.rafaelfelipeac.replyradar.core.datetime.Clock

class FakeClock(private val fixedNow: Long) : Clock {
    override fun now(): Long = fixedNow
}
