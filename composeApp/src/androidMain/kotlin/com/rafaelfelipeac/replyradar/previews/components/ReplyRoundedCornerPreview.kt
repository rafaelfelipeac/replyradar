package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRoundedCorner
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview
@Composable
fun ReplyRoundedCornerPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = colorScheme.primary,
                    shape = ReplyRoundedCorner()
                )
        )
    }
}

@Preview
@Composable
fun ReplyRoundedCornerDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color = colorScheme.primary,
                    shape = ReplyRoundedCorner()
                )
        )
    }
}
