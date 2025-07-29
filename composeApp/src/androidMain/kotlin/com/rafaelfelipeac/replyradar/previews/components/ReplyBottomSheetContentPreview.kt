package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetContent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState

@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetContentPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyBottomSheetContent(
            replyBottomSheetState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.CREATE,
                reply = Reply(
                    id = 1,
                    subject = "Message",
                    name = "Contact",
                    isResolved = false
                )
            ),
            onSave = {},
            onResolve = {},
            onArchive = {},
            onDelete = {},
            onInvalidReminderValue = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetContentDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyBottomSheetContent(
            replyBottomSheetState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.CREATE,
                reply = Reply(
                    id = 1,
                    subject = "Message",
                    name = "Contact",
                    isResolved = false
                )
            ),
            onSave = {},
            onResolve = {},
            onArchive = {},
            onDelete = {},
            onInvalidReminderValue = {}
        )
    }
}
