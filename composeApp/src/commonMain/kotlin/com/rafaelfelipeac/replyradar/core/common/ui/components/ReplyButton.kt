package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.common.ui.buttonHeight

@Composable
fun ReplyButton(modifier: Modifier, text: String, onClick: () -> Unit, enabled: Boolean = true) {
    Button(
        modifier = modifier
            .height(buttonHeight),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorScheme.secondary
        ),
        enabled = enabled
    ) {
        Text(text)
    }
}
