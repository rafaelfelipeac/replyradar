package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetActions
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState
import com.rafaelfelipeac.replyradar.previews.Replies
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetActionsPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyBottomSheetActions(
            state = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.CREATE
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
fun ReplyBottomSheetActionsPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyBottomSheetActions(
            state = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.EDIT,
                reply = Replies.OnTheRadar.reply1
            ),
            onArchive = {},
            onResolve = {},
            onDelete = {},
            onSave = {},
            onInvalidReminderValue = {},
            selectedDate = null,
            selectedTime = null,
            reply = null,
            name = Replies.OnTheRadar.reply1.name,
            subject = Replies.OnTheRadar.reply1.subject
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetActionsDarkPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyBottomSheetActions(
            state = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.CREATE
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
fun ReplyBottomSheetActionsDarkPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyBottomSheetActions(
            state = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.EDIT,
                reply = Replies.OnTheRadar.reply1
            ),
            onArchive = {},
            onResolve = {},
            onDelete = {},
            onSave = {},
            onInvalidReminderValue = {},
            selectedDate = null,
            selectedTime = null,
            reply = null,
            name = Replies.OnTheRadar.reply1.name,
            subject = Replies.OnTheRadar.reply1.subject
        )
    }
}
