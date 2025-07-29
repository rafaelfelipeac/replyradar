package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium

@Composable
fun ReplyRadarPlaceholder(message: String) {
    Text(
        modifier = Modifier
            .padding(horizontal = paddingMedium),
        text = message,
        textAlign = TextAlign.Center,
        style = typography.headlineSmall
    )
}
