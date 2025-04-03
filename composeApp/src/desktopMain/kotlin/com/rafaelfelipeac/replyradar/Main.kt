package com.rafaelfelipeac.replyradar

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rafaelfelipeac.replyradar.app.ReplyRadarApp
import com.rafaelfelipeac.replyradar.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Reply Radar"
        ) {
            ReplyRadarApp()
        }
    }
}
