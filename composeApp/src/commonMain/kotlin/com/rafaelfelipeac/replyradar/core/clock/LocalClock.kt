package com.rafaelfelipeac.replyradar.core.clock

import androidx.compose.runtime.staticCompositionLocalOf
import com.rafaelfelipeac.replyradar.core.datetime.Clock

val LocalClock = staticCompositionLocalOf<Clock> {
    error("No Clock provided")
}
