package com.rafaelfelipeac.replyradar

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.app.ReplyRadarApp
import com.rafaelfelipeac.replyradar.core.util.setStatusBarColorCompat

@Composable
@Preview
fun AndroidApp() {
    val activity = LocalContext.current as? Activity

    ReplyRadarApp(
        onStatusBarConfig = {
            SideEffect {
                activity?.setStatusBarColorCompat(
                    color = White,
                    useDarkIcons = true
                )
            }
        }
    )
}
