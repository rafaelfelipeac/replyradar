package com.rafaelfelipeac.replyradar

import androidx.compose.ui.window.ComposeUIViewController
import com.rafaelfelipeac.replyradar.app.ReplyRadarApp
import com.rafaelfelipeac.replyradar.di.initKoin

@Suppress("FunctionNaming")
fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { ReplyRadarApp() }
