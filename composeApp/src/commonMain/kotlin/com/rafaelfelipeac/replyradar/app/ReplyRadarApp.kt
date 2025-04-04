package com.rafaelfelipeac.replyradar.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.rafaelfelipeac.replyradar.app.navigation.AppNavHost
import com.rafaelfelipeac.replyradar.core.common.ui.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.LIGHT
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun ReplyRadarApp(onStatusBarConfig: @Composable (() -> Unit)? = null) {
    onStatusBarConfig?.invoke()

    MaterialTheme {
        val navController = rememberNavController()
        val theme = LIGHT

        val isDarkTheme = when (theme) {
            LIGHT -> false
            DARK -> true
            SYSTEM -> isSystemInDarkTheme()
        }

        ReplyRadarTheme(darkTheme = isDarkTheme) {
            AppNavHost(navController = navController)
        }
    }
}
