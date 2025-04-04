package com.rafaelfelipeac.replyradar.core.common.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

object ReplyRadarTheme {
    val colors: ReplyRadarColors
        @Composable
        get() = LocalReplyRadarColors.current
}

val ColorScheme.buttonBorderColor: Color
    @Composable get() = ReplyRadarTheme.colors.buttonBorderColor

val ColorScheme.horizontalDividerColor: Color
    @Composable get() = ReplyRadarTheme.colors.horizontalDividerColor

val ColorScheme.textFieldPlaceholderColor: Color
    @Composable get() = ReplyRadarTheme.colors.textFieldPlaceholderColor

val ColorScheme.unselectedTabColor: Color
    @Composable get() = ReplyRadarTheme.colors.unselectedTabColor

@Composable
fun ReplyRadarTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val extraColors = if (darkTheme) DarkExtraColors else LightExtraColors

    CompositionLocalProvider(
        LocalReplyRadarColors provides extraColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
