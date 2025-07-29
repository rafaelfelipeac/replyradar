package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.ReplyTimestampInfo
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState

@Preview(showBackground = true)
@Composable
fun ReplyTimestampInfoPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        Column {
            ReplyTimestampInfo(
                state = ReplyBottomSheetState(
                    reply = Reply(
                        id = 1,
                        message = "Message",
                        isResolved = false
                    )
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTimestampInfoDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        Column {
            ReplyTimestampInfo(
                state = ReplyBottomSheetState(
                    reply = Reply(
                        id = 1,
                        message = "Message",
                        isResolved = false
                    )
                )
            )
        }
    }
}
