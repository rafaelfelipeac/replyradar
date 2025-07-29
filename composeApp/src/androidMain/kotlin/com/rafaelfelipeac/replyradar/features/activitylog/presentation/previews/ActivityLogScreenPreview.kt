package com.rafaelfelipeac.replyradar.features.activitylog.presentation.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogScreen
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import kotlinx.datetime.Clock
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogListItem

@Preview(showBackground = true)
@Composable
fun ActivityLogScreenPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ActivityLogScreen(
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityLogScreenDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ActivityLogScreen(
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityLogListItemPreview() {
    ReplyRadarTheme(
        darkTheme = false
    ) {
        ActivityLogListItem(
            userAction = UserAction(
                id = 1,
                actionType = UserActionType.Create,
                targetType = UserActionTargetType.Message,
                targetName = "User Action 1",
                createdAt = Clock.System.now().toEpochMilliseconds()
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityLogListItemDarkPreview() {
    ReplyRadarTheme(
        darkTheme = true
    ) {
        ActivityLogListItem(
            userAction = UserAction(
                id = 1,
                actionType = UserActionType.Create,
                targetType = UserActionTargetType.Message,
                targetName = "User Action 1",
                createdAt = Clock.System.now().toEpochMilliseconds()
            )
        )
    }
}
