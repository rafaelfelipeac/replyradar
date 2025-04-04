package com.rafaelfelipeac.replyradar.core.common.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White

private val PrimaryColor = Color(0xFF464152)
private val AccentColor = Color(0xFF7180ac)

private const val UnselectedTabAlpha = 0.5f

val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = AccentColor,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
)

val LightExtraColors = ReplyRadarColors(
    textFieldPlaceholderColor = Gray,
    buttonBorderColor = LightGray,
    horizontalDividerColor = LightGray,
    unselectedTabColor = Black.copy(alpha = UnselectedTabAlpha)
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
