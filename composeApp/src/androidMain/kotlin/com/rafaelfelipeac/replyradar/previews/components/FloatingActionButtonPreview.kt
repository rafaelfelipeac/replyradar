package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.FloatingActionButton

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    ReplyRadarTheme(darkTheme = false) {
        FloatingActionButton(
            onIntent = {},
            colorScheme = MaterialTheme.colorScheme
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonDarkPreview() {
    ReplyRadarTheme(darkTheme = true) {
        FloatingActionButton(
            onIntent = {},
            colorScheme = MaterialTheme.colorScheme
        )
    }
}
