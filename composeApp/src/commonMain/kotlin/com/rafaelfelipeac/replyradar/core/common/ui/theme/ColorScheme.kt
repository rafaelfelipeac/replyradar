package com.rafaelfelipeac.replyradar.core.common.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

private const val UnselectedTabAlpha = 0.5f

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF464152),
    secondary = Color(0xFF7180AC),
    background = Color(0xFFF7F7F7),
    onBackground = Color(0xFF1E1E1E),
    surface = Color(0xFFF7F7F7),
    onSurface = Color(0xFF1E1E1E),
)

val LightExtraColors = ReplyRadarColors(
    textFieldPlaceholderColor = Color(0xFF888888),
    buttonBorderColor = Color(0xFFCCCCCC),
    horizontalDividerColor = Color(0xFFE0E0E0),
    unselectedTabColor = Color(0xFF1E1E1E).copy(alpha = UnselectedTabAlpha)
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFB3B8EF),
    secondary = Color(0xFF9FA8DA),
    background = Color(0xFF1E1E1E),
    onBackground = Color(0xFFEDEDED),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFEDEDED),
)

val DarkExtraColors = ReplyRadarColors(
    textFieldPlaceholderColor = Color(0xFFAAAAAA),
    buttonBorderColor = Color(0xFF444444),
    horizontalDividerColor = Color(0xFF333333),
    unselectedTabColor = Color(0xFFEDEDED).copy(alpha = UnselectedTabAlpha)
)
