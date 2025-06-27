package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
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
