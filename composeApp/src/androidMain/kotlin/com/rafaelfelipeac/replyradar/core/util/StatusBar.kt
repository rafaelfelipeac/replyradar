package com.rafaelfelipeac.replyradar.core.util

import android.app.Activity
import androidx.core.view.WindowCompat
import androidx.compose.ui.graphics.Color

fun Activity.setStatusBarColorCompat(color: Color, useDarkIcons: Boolean) {
    val window = this.window

    window.statusBarColor = android.graphics.Color.argb(
        (color.alpha * 255).toInt(),
        (color.red * 255).toInt(),
        (color.green * 255).toInt(),
        (color.blue * 255).toInt()
    )

    WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = useDarkIcons
}
