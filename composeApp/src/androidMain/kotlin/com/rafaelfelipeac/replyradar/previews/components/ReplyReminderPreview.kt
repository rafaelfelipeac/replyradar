package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyReminder
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Preview(showBackground = true)
@Composable
fun ReplyReminderPreview() {
    val now = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    ReplyRadarTheme {
        ReplyReminder(
            selectedTime = now.time,
            selectedDate = now.date,
            onSelectedTimeChange = {},
            onSelectedDateChange = {},
            closeKeyboard = { null }
        )
    }
}
