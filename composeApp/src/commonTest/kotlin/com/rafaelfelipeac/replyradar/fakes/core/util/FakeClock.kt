package com.rafaelfelipeac.replyradar.fakes.core.util

import com.rafaelfelipeac.replyradar.core.util.Clock

class FakeClock(private val fixedNow: Long) : Clock {
    override fun now(): Long = fixedNow
}
