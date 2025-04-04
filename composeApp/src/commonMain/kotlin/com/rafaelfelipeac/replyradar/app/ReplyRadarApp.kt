package com.rafaelfelipeac.replyradar.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.rafaelfelipeac.replyradar.app.navigation.AppNavHost
import com.rafaelfelipeac.replyradar.core.common.ui.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.isDarkTheme
import com.rafaelfelipeac.replyradar.features.app.settings.AppSettingsViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun ReplyRadarApp(onStatusBarConfig: @Composable (() -> Unit)? = null) {
    onStatusBarConfig?.invoke()

    MaterialTheme {
        val navController = rememberNavController()
        val appSettingsViewModel = koinViewModel<AppSettingsViewModel>()
        val currentTheme by appSettingsViewModel.theme.collectAsState()

        ReplyRadarTheme(darkTheme = isDarkTheme(currentTheme)) {
            AppNavHost(navController = navController)
        }
    }
}
