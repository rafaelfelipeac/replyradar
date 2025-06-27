package com.rafaelfelipeac.replyradar.core.datetime

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual fun getClock(): Clock = object : Clock {
    override fun now(): Long {
        return (NSDate().timeIntervalSince1970 * CLOCK_MULTIPLIER).toLong()
    }
}

private const val CLOCK_MULTIPLIER = 1000
