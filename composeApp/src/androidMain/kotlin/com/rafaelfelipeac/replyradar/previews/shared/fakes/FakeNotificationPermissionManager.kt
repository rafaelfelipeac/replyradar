package com.rafaelfelipeac.replyradar.previews.shared.fakes

import com.rafaelfelipeac.replyradar.core.notification.NotificationPermissionManager

class FakeNotificationPermissionManager : NotificationPermissionManager {
    override suspend fun ensureNotificationPermission(): Boolean = true
    override suspend fun goToAppSettings() {}
}
