package com.rafaelfelipeac.replyradar.previews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Composable
fun ReplyRadarPreviewWrapper(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalReplyRadarStrings provides PreviewStringsFake) {
        ReplyRadarTheme(darkTheme = darkTheme) {
            content()
        }
    }
}
