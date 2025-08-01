package com.rafaelfelipeac.replyradar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color.Companion.Black
import com.rafaelfelipeac.replyradar.app.ReplyRadarApp
import com.rafaelfelipeac.replyradar.core.ConfigureSystemBars
import com.rafaelfelipeac.replyradar.core.notification.rememberNotificationPermissionManager

@Composable
fun AndroidApp(pendingReplyId: Long?) {
    var isDark by remember { mutableStateOf(false) }
    var backgroundColor by remember { mutableStateOf(Black) }

    ConfigureSystemBars(darkTheme = isDark, backgroundColor = backgroundColor)

    ReplyRadarApp(
        onSystemBarsConfigured = { dark, bgColor ->
            isDark = dark
            backgroundColor = bgColor
        },
        notificationPermissionManager = rememberNotificationPermissionManager(),
        pendingReplyId = pendingReplyId
    )
}
