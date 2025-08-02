package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogListItem
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Feedback
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Language
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Message
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Rate
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Theme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Archive
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Create
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Delete
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Edit
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Open
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.OpenedNotification
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Reopen
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Resolve
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Scheduled
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Unarchive
import com.rafaelfelipeac.replyradar.previews.shared.Replies
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import kotlinx.datetime.Clock

@Preview(showBackground = true)
@Composable
fun PreviewCreateMessage() = PreviewAction(
    id = 1,
    type = Create,
    target = Message,
    name = Replies.OnTheRadar.reply1.name
)

@Preview(showBackground = true)
@Composable
fun PreviewEditMessage() = PreviewAction(
    id = 2,
    type = Edit,
    target = Message,
    name = Replies.OnTheRadar.reply2.name,
    timeOffsetMillis = 1_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewResolveMessage() = PreviewAction(
    id = 3,
    type = Resolve,
    target = Message,
    name = Replies.Resolved.reply3.name,
    timeOffsetMillis = 2_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewReopenMessage() = PreviewAction(
    id = 4,
    type = Reopen,
    target = Message,
    name = Replies.Resolved.reply4.name,
    timeOffsetMillis = 3_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewArchiveMessage() = PreviewAction(
    id = 5,
    type = Archive,
    target = Message,
    name = Replies.Archived.reply1.name,
    timeOffsetMillis = 4_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewUnarchiveMessage() = PreviewAction(
    id = 6,
    type = Unarchive,
    target = Message,
    name = Replies.Archived.reply2.name,
    timeOffsetMillis = 5_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewDeleteMessage() = PreviewAction(
    id = 7,
    type = Delete,
    target = Message,
    name = Replies.OnTheRadar.reply3.name,
    timeOffsetMillis = 6_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewScheduledMessage() = PreviewAction(
    id = 8,
    type = Scheduled,
    target = Message,
    name = Replies.OnTheRadar.reply4.name,
    timeOffsetMillis = 7_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewOpenedNotificationMessage() = PreviewAction(
    id = 9,
    type = OpenedNotification,
    target = Message,
    name = Replies.OnTheRadar.reply5.name,
    timeOffsetMillis = 8_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewOpenMessage() = PreviewAction(
    id = 10,
    type = Open,
    target = Message,
    name = Replies.OnTheRadar.reply1.name,
    timeOffsetMillis = 9_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateTheme() = PreviewAction(
    id = 11,
    type = Create,
    target = Theme,
    name = null,
    timeOffsetMillis = 10_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateLanguage() = PreviewAction(
    id = 12,
    type = Create,
    target = Language,
    name = null,
    timeOffsetMillis = 11_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateFeedback() = PreviewAction(
    id = 13,
    type = Create,
    target = Feedback,
    name = null,
    timeOffsetMillis = 12_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateRate() = PreviewAction(
    id = 14,
    type = Create,
    target = Rate,
    name = null,
    timeOffsetMillis = 13_000_000L
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateMessageDark() = PreviewAction(
    id = 1,
    type = Create,
    target = Message,
    name = Replies.OnTheRadar.reply1.name,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewEditMessageDark() = PreviewAction(
    id = 2,
    type = Edit,
    target = Message,
    name = Replies.OnTheRadar.reply2.name,
    timeOffsetMillis = 1_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewResolveMessageDark() = PreviewAction(
    id = 3,
    type = Resolve,
    target = Message,
    name = Replies.Resolved.reply3.name,
    timeOffsetMillis = 2_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewReopenMessageDark() = PreviewAction(
    id = 4,
    type = Reopen,
    target = Message,
    name = Replies.Resolved.reply4.name,
    timeOffsetMillis = 3_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewArchiveMessageDark() = PreviewAction(
    id = 5,
    type = Archive,
    target = Message,
    name = Replies.Archived.reply1.name,
    timeOffsetMillis = 4_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewUnarchiveMessageDark() = PreviewAction(
    id = 6,
    type = Unarchive,
    target = Message,
    name = Replies.Archived.reply2.name,
    timeOffsetMillis = 5_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewDeleteMessageDark() = PreviewAction(
    id = 7,
    type = Delete,
    target = Message,
    name = Replies.OnTheRadar.reply3.name,
    timeOffsetMillis = 6_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewScheduledMessageDark() = PreviewAction(
    id = 8,
    type = Scheduled,
    target = Message,
    name = Replies.OnTheRadar.reply4.name,
    timeOffsetMillis = 7_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewOpenedNotificationMessageDark() = PreviewAction(
    id = 9,
    type = OpenedNotification,
    target = Message,
    name = Replies.OnTheRadar.reply5.name,
    timeOffsetMillis = 8_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewOpenMessageDark() = PreviewAction(
    id = 10,
    type = Open,
    target = Message,
    name = Replies.OnTheRadar.reply1.name,
    timeOffsetMillis = 9_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateThemeDark() = PreviewAction(
    id = 11,
    type = Create,
    target = Theme,
    name = null,
    timeOffsetMillis = 10_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateLanguageDark() = PreviewAction(
    id = 12,
    type = Create,
    target = Language,
    name = null,
    timeOffsetMillis = 11_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateFeedbackDark() = PreviewAction(
    id = 13,
    type = Create,
    target = Feedback,
    name = null,
    timeOffsetMillis = 12_000_000L,
    darkTheme = true
)

@Preview(showBackground = true)
@Composable
fun PreviewCreateRateDark() = PreviewAction(
    id = 14,
    type = Create,
    target = Rate,
    name = null,
    timeOffsetMillis = 13_000_000L,
    darkTheme = true
)

@Composable
private fun PreviewAction(
    id: Long,
    type: UserActionType,
    target: UserActionTargetType,
    name: String? = null,
    timeOffsetMillis: Long = 0L,
    darkTheme: Boolean = false
) = ReplyRadarPreviewWrapper(darkTheme = darkTheme) {
    ActivityLogListItem(
        userAction = UserAction(
            id = id,
            actionType = type,
            targetType = target,
            targetName = name,
            createdAt = Clock.System.now().toEpochMilliseconds() - timeOffsetMillis
        )
    )
}
