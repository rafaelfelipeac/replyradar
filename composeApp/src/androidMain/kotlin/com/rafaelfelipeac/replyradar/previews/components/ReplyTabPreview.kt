package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTab
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper

@Preview(showBackground = true)
@Composable
fun ReplyTabPreview() {
    ReplyRadarPreviewWrapper(darkTheme = false) {
        TabRow(
            selectedTabIndex = 0,
            containerColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[0]),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        ) {
            ReplyTab(
                selected = true,
                onClick = {},
                text = PreviewStringsFake.replyListTabOnTheRadar
            )
            ReplyTab(
                selected = false,
                onClick = {},
                text = PreviewStringsFake.replyListTabResolved
            )
            ReplyTab(
                selected = false,
                onClick = {},
                text = PreviewStringsFake.replyListTabArchived
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTabDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        TabRow(
            selectedTabIndex = 0,
            containerColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[0]),
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        ) {
            ReplyTab(
                selected = true,
                onClick = {},
                text = PreviewStringsFake.replyListTabOnTheRadar
            )
            ReplyTab(
                selected = false,
                onClick = {},
                text = PreviewStringsFake.replyListTabResolved
            )
            ReplyTab(
                selected = false,
                onClick = {},
                text = PreviewStringsFake.replyListTabArchived
            )
        }
    }
}
