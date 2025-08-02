package com.rafaelfelipeac.replyradar.previews.shared.fakes

import com.rafaelfelipeac.replyradar.core.notification.NotificationPermissionManager

@Suppress("EmptyFunctionBlock")
class FakeNotificationPermissionManager : NotificationPermissionManager {
    override suspend fun ensureNotificationPermission(): Boolean = true
    override suspend fun goToAppSettings() {}
}
