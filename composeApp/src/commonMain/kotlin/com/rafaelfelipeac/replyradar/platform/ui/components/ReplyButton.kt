package com.rafaelfelipeac.replyradar.platform.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.platform.ui.AccentColor

@Composable
fun ReplyButton(modifier: Modifier, text: String, onClick:() -> Unit, enabled: Boolean = true) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = AccentColor
        ),
        enabled = enabled
    ) {
        Text(text)
    }
}