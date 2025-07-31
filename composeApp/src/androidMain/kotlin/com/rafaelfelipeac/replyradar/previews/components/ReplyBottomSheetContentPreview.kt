package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetContent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState
import com.rafaelfelipeac.replyradar.previews.shared.Replies
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetContentPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyBottomSheetContent(
            replyBottomSheetState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.CREATE,
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
fun ReplyBottomSheetContentPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyBottomSheetContent(
            replyBottomSheetState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.EDIT,
                reply = Replies.OnTheRadar.reply1
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
fun ReplyBottomSheetContentDarkPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyBottomSheetContent(
            replyBottomSheetState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.CREATE,
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
fun ReplyBottomSheetContentDarkPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyBottomSheetContent(
            replyBottomSheetState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.EDIT,
                reply = Replies.OnTheRadar.reply1
            ),
            onSave = {},
            onResolve = {},
            onArchive = {},
            onDelete = {},
            onInvalidReminderValue = {}
        )
    }
}
