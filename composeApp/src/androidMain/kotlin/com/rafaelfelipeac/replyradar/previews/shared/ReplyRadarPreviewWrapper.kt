package com.rafaelfelipeac.replyradar.previews.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.rafaelfelipeac.replyradar.core.notification.LocalNotificationPermissionManager
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.previews.shared.fakes.FakeNotificationPermissionManager
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake

@Composable
fun ReplyRadarPreviewWrapper(darkTheme: Boolean = false, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalReplyRadarStrings provides PreviewStringsFake,
        LocalNotificationPermissionManager provides FakeNotificationPermissionManager()
    ) {
        ReplyRadarTheme(darkTheme = darkTheme) {
            content()
        }
    }
}
