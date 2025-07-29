package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings

@Composable
fun ReplyRadarError(errorMessage: String? = null) {
    Text(
        text = errorMessage ?: LocalReplyRadarStrings.current.genericErrorMessage,
        textAlign = TextAlign.Center,
        style = typography.headlineSmall
    )
}
