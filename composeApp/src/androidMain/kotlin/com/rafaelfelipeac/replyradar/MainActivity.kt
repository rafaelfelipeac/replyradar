package com.rafaelfelipeac.replyradar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INVALID_ID
import com.rafaelfelipeac.replyradar.core.util.AppConstants.PENDING_REPLY_ID_KEY

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pendingReplyId = intent?.getLongExtra(PENDING_REPLY_ID_KEY, INVALID_ID)

        setContent {
            AndroidApp(pendingReplyId = pendingReplyId)
        }
    }
}
