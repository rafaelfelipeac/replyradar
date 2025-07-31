package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogListItem
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.previews.shared.Replies
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import kotlinx.datetime.Clock

@Preview(showBackground = true)
@Composable
fun ActivityLogListItemPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        ActivityLogListItem(
            userAction = UserAction(
                id = 1,
                actionType = UserActionType.Create,
                targetType = UserActionTargetType.Message,
                targetName = Replies.OnTheRadar.reply1.name,
                createdAt = Clock.System.now().toEpochMilliseconds()
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityLogListItemDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        ActivityLogListItem(
            userAction = UserAction(
                id = 1,
                actionType = UserActionType.Create,
                targetType = UserActionTargetType.Message,
                targetName = Replies.OnTheRadar.reply1.name,
                createdAt = Clock.System.now().toEpochMilliseconds()
            )
        )
    }
}
