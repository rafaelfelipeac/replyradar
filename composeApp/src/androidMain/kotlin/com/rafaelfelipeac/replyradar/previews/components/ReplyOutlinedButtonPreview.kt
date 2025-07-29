package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyOutlinedButton
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import replyradar.composeapp.generated.resources.Res
import replyradar.composeapp.generated.resources.ic_date
import replyradar.composeapp.generated.resources.ic_time

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ReplyOutlinedButton(
            text = "September 11, 2024",
            icon = Res.drawable.ic_date,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ReplyOutlinedButton(
            text = "10:30",
            icon = Res.drawable.ic_time,
            onClick = {}
        )
    }
}
