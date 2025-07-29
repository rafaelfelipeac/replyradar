package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetActions
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState

@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetActionsPreview() {
    ReplyRadarTheme {
        ReplyBottomSheetActions(
            state = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.EDIT,
                reply = Reply(
                    id = 1,
                    message = "Message",
                    isResolved = false
                )
            ),
            onArchive = {},
            onResolve = {},
            onDelete = {},
            onSave = {},
            onInvalidReminderValue = {},
            selectedDate = null,
            selectedTime = null,
            reply = null,
            name = "",
            subject = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetActionsDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyBottomSheetActions(
            state = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.EDIT,
                reply = Reply(
                    id = 1,
                    message = "Message",
                    isResolved = false
                )
            ),
            onArchive = {},
            onResolve = {},
            onDelete = {},
            onSave = {},
            onInvalidReminderValue = {},
            selectedDate = null,
            selectedTime = null,
            reply = null,
            name = "",
            subject = ""
        )
    }
}
