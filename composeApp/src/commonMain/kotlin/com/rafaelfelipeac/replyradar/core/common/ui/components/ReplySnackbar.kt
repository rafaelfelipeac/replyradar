package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.theme.snackbarBackgroundColor

@Composable
fun ReplySnackbar(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { snackbarData ->
            Snackbar(
                snackbarData = snackbarData,
                containerColor = colorScheme.snackbarBackgroundColor,
                contentColor = colorScheme.onSurface
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ReplySnackbarPreview() {
    ReplyRadarTheme {
        ReplySnackbar(
            snackbarHostState = SnackbarHostState()
        )
    }
}
