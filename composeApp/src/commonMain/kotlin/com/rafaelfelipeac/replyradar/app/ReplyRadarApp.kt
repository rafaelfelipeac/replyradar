package com.rafaelfelipeac.replyradar.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.rafaelfelipeac.replyradar.app.navigation.AppNavHost
import com.rafaelfelipeac.replyradar.core.common.ui.theme.DarkColorScheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.LightColorScheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.features.app.settings.AppSettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ReplyRadarApp(
    onSystemBarsConfigured: ((isDark: Boolean, backgroundColor: Color) -> Unit)? = null
) {
    val navController = rememberNavController()
    val appSettingsViewModel = koinViewModel<AppSettingsViewModel>()
    val theme by appSettingsViewModel.theme.collectAsStateWithLifecycle()

    val isDark = theme == DARK || (theme == SYSTEM && isSystemInDarkTheme())
    val backgroundColor = if (isDark) DarkColorScheme.background else LightColorScheme.background

    LaunchedEffect(isDark, backgroundColor) {
        onSystemBarsConfigured?.invoke(isDark, backgroundColor)
    }

    ReplyRadarTheme(darkTheme = isDark) {
        AppNavHost(navController = navController)
    }
}
