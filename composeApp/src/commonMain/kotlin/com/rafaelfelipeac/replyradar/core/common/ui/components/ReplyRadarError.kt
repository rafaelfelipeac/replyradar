package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ReplyRadarError(errorMessage: String?) {
    Text(
        text = errorMessage ?: GENERIC_ERROR_MESSAGE,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineSmall
    )
}

const val GENERIC_ERROR_MESSAGE = ""
