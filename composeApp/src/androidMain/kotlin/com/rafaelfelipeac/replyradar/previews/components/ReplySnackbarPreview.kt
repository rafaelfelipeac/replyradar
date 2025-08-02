package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.core.theme.snackbarBackgroundColor
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake

// ReplySnackbar can't be used directly in Preview because SnackbarHostState requires an active SnackbarData,
// which is only created at runtime via showSnackbar() inside a coroutine.
// Since @Preview doesn't execute effects like LaunchedEffect, no snackbar is shown.
// This manually simulates the visual result of ReplySnackbar.

@Preview(showBackground = true)
@Composable
fun ReplySnackbarPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Box(
            modifier = Modifier
                .background(colorScheme.onSurface)
                .padding(4.dp)
        ) {
            Snackbar(
                containerColor = colorScheme.snackbarBackgroundColor,
                contentColor = colorScheme.onSurface
            ) {
                Text(PreviewStringsFake.replyListSnackbarResolved)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplySnackbarDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Box(
            modifier = Modifier
                .background(colorScheme.onSurface)
                .padding(4.dp)
        ) {
            Snackbar(
                containerColor = colorScheme.snackbarBackgroundColor,
                contentColor = colorScheme.onSurface
            ) {
                Text(PreviewStringsFake.replyListSnackbarResolved)
            }
        }
    }
}
