package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Composable
fun ReplyProgress() {
    CircularProgressIndicator()
}

@Preview(showBackground = true)
@Composable
fun ReplyProgressPreview() {
    ReplyRadarTheme {
        ReplyProgress()
    }
}
