package com.rafaelfelipeac.replyradar.core.common.ui.components.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyOutlinedButton
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import replyradar.composeapp.generated.resources.Res
import replyradar.composeapp.generated.resources.ic_calendar
import replyradar.composeapp.generated.resources.ic_clock

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonPreview() {
    ReplyRadarTheme {
        ReplyOutlinedButton(
            text = "September 11, 2024",
            icon = Res.drawable.ic_calendar,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonPreview2() {
    ReplyRadarTheme {
        ReplyOutlinedButton(
            text = "10:30",
            icon = Res.drawable.ic_clock,
            onClick = {}
        )
    }
}
