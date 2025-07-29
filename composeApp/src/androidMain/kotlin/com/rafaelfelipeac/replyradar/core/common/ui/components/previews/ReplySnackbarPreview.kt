package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplySnackbar
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Preview(showBackground = true)
@Composable
fun ReplySnackbarPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplySnackbar(
            snackbarHostState = SnackbarHostState()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplySnackbarDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplySnackbar(
            snackbarHostState = SnackbarHostState()
        )
    }
}
