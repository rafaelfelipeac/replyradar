package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Composable
fun ReplyRadarError(errorMessage: String? = null) {
    Text(
        text = errorMessage ?: LocalReplyRadarStrings.current.genericErrorMessage,
        textAlign = TextAlign.Center,
        style = typography.headlineSmall
    )
}

@Preview(showBackground = true)
@Composable
fun ReplyRadarErrorPreview() {
    ReplyRadarTheme {
        ReplyRadarError()
    }
}
