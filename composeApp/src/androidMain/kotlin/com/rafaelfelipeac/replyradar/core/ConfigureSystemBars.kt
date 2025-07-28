package com.rafaelfelipeac.replyradar.core

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ConfigureSystemBars(darkTheme: Boolean, backgroundColor: Color) {
    val activity = LocalContext.current as? Activity
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setNavigationBarColor(
            color = backgroundColor,
            darkIcons = !darkTheme
        )

        activity?.setStatusBarColorCompat(
            color = backgroundColor,
            useDarkIcons = !darkTheme
        )
    }
}
