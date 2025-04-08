package com.rafaelfelipeac.replyradar.core.common.ui.theme

import androidx.compose.runtime.Composable

object ReplyRadarThemeAccessors {
    val colors: ReplyRadarColors
        @Composable
        get() = LocalReplyRadarColors.current
}
