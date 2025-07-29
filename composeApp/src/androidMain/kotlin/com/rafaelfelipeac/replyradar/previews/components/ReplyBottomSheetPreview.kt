package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheet
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

        ReplyBottomSheet(
            sheetState = sheetState,
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
            onDismiss = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ReplyBottomSheetDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

        ReplyBottomSheet(
            sheetState = sheetState,
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
            onDismiss = {}
        )
    }
}
