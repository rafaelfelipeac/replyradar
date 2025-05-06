package com.rafaelfelipeac.replyradar.core.notification

interface NotificationPermissionManager {
    suspend fun ensureNotificationPermission(): Boolean
}
