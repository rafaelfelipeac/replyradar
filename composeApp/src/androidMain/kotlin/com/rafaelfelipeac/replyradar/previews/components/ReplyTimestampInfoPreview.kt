package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.ReplyTimestampInfo
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState
import com.rafaelfelipeac.replyradar.previews.Replies
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyTimestampInfoPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
        ) {
            ReplyTimestampInfo(
                state = ReplyBottomSheetState(
                    reply = Replies.OnTheRadar.reply1
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTimestampInfoDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
        ) {
            ReplyTimestampInfo(
                state = ReplyBottomSheetState(
                    reply = Replies.OnTheRadar.reply1
                )
            )
        }
    }
}
