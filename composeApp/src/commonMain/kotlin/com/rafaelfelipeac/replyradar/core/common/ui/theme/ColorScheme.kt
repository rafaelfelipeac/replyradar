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
    primary = Black,
    secondary = Black,
    background = Black,
    onBackground = Black,
    surface = Black,
    onSurface = Black,
)

val DarkExtraColors = ReplyRadarColors(
    textFieldPlaceholderColor = Black,
    buttonBorderColor = Black,
    horizontalDividerColor = Black,
    unselectedTabColor = Black.copy(alpha = UnselectedTabAlpha)
)
