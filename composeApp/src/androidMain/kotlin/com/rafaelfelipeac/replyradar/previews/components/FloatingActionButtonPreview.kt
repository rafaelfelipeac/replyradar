package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.FloatingActionButton
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    ReplyRadarPreviewWrapper(darkTheme = false) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(4.dp)
        ) {
            FloatingActionButton(
                onIntent = {},
                colorScheme = MaterialTheme.colorScheme
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonDarkPreview() {
    ReplyRadarPreviewWrapper(darkTheme = true) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(4.dp)
        ) {
            FloatingActionButton(
                onIntent = {},
                colorScheme = MaterialTheme.colorScheme
            )
        }
    }
}
