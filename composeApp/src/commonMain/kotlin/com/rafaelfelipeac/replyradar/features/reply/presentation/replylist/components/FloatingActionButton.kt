package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnAddReplyClick

@Composable
fun FloatingActionButton(
    onIntent: (ReplyListScreenIntent) -> Unit = {},
    colorScheme: ColorScheme
) {
    FloatingActionButton(
        onClick = { onIntent(OnAddReplyClick) },
        containerColor = colorScheme.secondary
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = LocalReplyRadarStrings.current
                .replyListFabContentDescription,
            tint = colorScheme.background
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() {
    ReplyRadarTheme {
        FloatingActionButton(
            colorScheme = MaterialTheme.colorScheme
        )
    }
}
