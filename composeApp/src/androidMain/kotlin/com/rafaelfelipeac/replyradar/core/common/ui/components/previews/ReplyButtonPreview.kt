package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyButton
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme

@Preview(showBackground = true)
@Composable
fun ReplyButtonPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyButton(
            modifier = Modifier,
            text = "Button",
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyButtonDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyButton(
            modifier = Modifier,
            text = "Button",
            onClick = {}
        )
    }
}
