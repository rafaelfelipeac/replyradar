package com.rafaelfelipeac.replyradar.core.notification

import androidx.compose.runtime.compositionLocalOf

val LocalNotificationPermissionManager = compositionLocalOf<NotificationPermissionManager> {
    error("No NotificationPermissionManager provided")
}
