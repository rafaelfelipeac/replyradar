package com.rafaelfelipeac.replyradar.core.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.LIGHT
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM

@Composable
fun isDarkTheme(currentTheme: AppTheme) =
    when (currentTheme) {
        LIGHT -> false
        DARK -> true
        SYSTEM -> isSystemInDarkTheme()
    }
