package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTab
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake

@Preview(showBackground = true)
@Composable
fun ReplyTabOnTheRadarPreview() {
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
fun ReplyTabDarkOnTheRadarPreview() {
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

@Preview(showBackground = true)
@Composable
fun ReplyTabResolvedPreview() {
    ReplyRadarPreviewWrapper(darkTheme = false) {
        TabRow(
            selectedTabIndex = 1,
            containerColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[1]),
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
fun ReplyTabDarkResolvedPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        TabRow(
            selectedTabIndex = 1,
            containerColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[1]),
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
fun ReplyTabArchivedPreview() {
    ReplyRadarPreviewWrapper(darkTheme = false) {
        TabRow(
            selectedTabIndex = 2,
            containerColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[2]),
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
fun ReplyTabDarkArchivedPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        TabRow(
            selectedTabIndex = 2,
            containerColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[2]),
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
