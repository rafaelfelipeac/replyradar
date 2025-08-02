package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyProgress
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyProgressPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            ReplyProgress()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyProgressDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            ReplyProgress()
        }
    }
}
