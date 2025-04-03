package com.rafaelfelipeac.replyradar.core.util

import android.app.Activity
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat

fun Activity.setStatusBarColorCompat(color: Color, useDarkIcons: Boolean) {
    val window = this.window

    window.statusBarColor = android.graphics.Color.argb(
        (color.alpha * COLOR_MULTIPLIER).toInt(),
        (color.red * COLOR_MULTIPLIER).toInt(),
        (color.green * COLOR_MULTIPLIER).toInt(),
        (color.blue * COLOR_MULTIPLIER).toInt()
    )

    WindowCompat
        .getInsetsController(window, window.decorView).isAppearanceLightStatusBars = useDarkIcons
}

private const val COLOR_MULTIPLIER = 255
