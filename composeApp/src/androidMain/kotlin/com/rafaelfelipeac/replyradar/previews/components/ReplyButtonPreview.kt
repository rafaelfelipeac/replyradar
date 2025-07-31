package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyButton
import com.rafaelfelipeac.replyradar.previews.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyButtonPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ){
            ReplyButton(
                modifier = Modifier,
                text = "Button",
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyButtonDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            ReplyButton(
                modifier = Modifier,
                text = "Button",
                onClick = {}
            )
        }
    }
}
