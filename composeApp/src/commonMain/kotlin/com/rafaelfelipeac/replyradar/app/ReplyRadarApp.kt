package com.rafaelfelipeac.replyradar.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.rafaelfelipeac.replyradar.core.clock.LocalClock
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.strings.StringsProvider
import com.rafaelfelipeac.replyradar.core.theme.DarkColorScheme
import com.rafaelfelipeac.replyradar.core.theme.LightColorScheme
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.core.navigation.AppNavHost
import com.rafaelfelipeac.replyradar.core.notification.LocalNotificationPermissionManager
import com.rafaelfelipeac.replyradar.core.notification.NotificationPermissionManager
import com.rafaelfelipeac.replyradar.core.datetime.getClock
import com.rafaelfelipeac.replyradar.features.app.settings.AppSettingsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ReplyRadarApp(
    onSystemBarsConfigured: ((isDark: Boolean, backgroundColor: Color) -> Unit)? = null,
    notificationPermissionManager: NotificationPermissionManager
) {
    val navController = rememberNavController()
    val appSettingsViewModel = koinViewModel<AppSettingsViewModel>()

    val theme by appSettingsViewModel.theme.collectAsStateWithLifecycle()
    val language by appSettingsViewModel.language.collectAsStateWithLifecycle()

    val isDark = theme == DARK || (theme == SYSTEM && isSystemInDarkTheme())
    val backgroundColor = if (isDark) DarkColorScheme.background else LightColorScheme.background

    LaunchedEffect(isDark, backgroundColor) {
        onSystemBarsConfigured?.invoke(isDark, backgroundColor)
    }

    StringsProvider.setLanguage(language)
    val strings = StringsProvider.current

    CompositionLocalProvider(
        LocalReplyRadarStrings provides strings,
        LocalClock provides getClock(),
        LocalNotificationPermissionManager provides notificationPermissionManager
    ) {
        ReplyRadarTheme(darkTheme = isDark) {
            AppNavHost(navController = navController)
        }
    }
}
