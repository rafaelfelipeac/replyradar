package com.rafaelfelipeac.replyradar.core.common.clock

import androidx.compose.runtime.staticCompositionLocalOf
import com.rafaelfelipeac.replyradar.core.util.datetime.Clock

val LocalClock = staticCompositionLocalOf<Clock> {
    error("No Clock provided")
}
