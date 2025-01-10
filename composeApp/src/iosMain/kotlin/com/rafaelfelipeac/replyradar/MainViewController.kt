package com.rafaelfelipeac.replyradar

import androidx.compose.ui.window.ComposeUIViewController
import com.rafaelfelipeac.replyradar.app.App
import com.rafaelfelipeac.replyradar.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }