package com.rafaelfelipeac.replyradar.core.util

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

actual fun getClock(): Clock = object : Clock {
    override fun now(): Long {
        return (NSDate().timeIntervalSince1970 * 1000).toLong()
    }
}
