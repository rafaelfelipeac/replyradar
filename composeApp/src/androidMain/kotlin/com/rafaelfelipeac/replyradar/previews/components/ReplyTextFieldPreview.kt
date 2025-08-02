package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextField
import com.rafaelfelipeac.replyradar.previews.shared.Replies
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake

@Preview(showBackground = true)
@Composable
fun ReplyTextFieldPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyTextField(
            value = Replies.OnTheRadar.reply1.name,
            placeholder = PreviewStringsFake.replyListBottomSheetName,
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTextFieldPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ReplyTextField(
            value = "",
            placeholder = PreviewStringsFake.replyListBottomSheetName,
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTextFieldDarkPreview1() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyTextField(
            value = "",
            placeholder = PreviewStringsFake.replyListBottomSheetName,
            onValueChange = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTextFieldDarkPreview2() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ReplyTextField(
            value = Replies.OnTheRadar.reply1.name,
            placeholder = PreviewStringsFake.replyListBottomSheetName,
            onValueChange = {}
        )
    }
}
