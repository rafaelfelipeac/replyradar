package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarError
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplyRadarErrorPreview() {
    ReplyRadarTheme {
        ReplyRadarError()
    }
}
