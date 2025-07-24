package com.rafaelfelipeac.replyradar.features.activitylog.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyProgress
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarError
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRadarPlaceholder
import com.rafaelfelipeac.replyradar.core.common.ui.iconSize
import com.rafaelfelipeac.replyradar.core.common.ui.listDividerThickness
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.datetime.formatTimestamp
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.theme.horizontalDividerColor
import com.rafaelfelipeac.replyradar.core.util.AppConstants.EMPTY
import com.rafaelfelipeac.replyradar.core.util.format
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogViewModel.Companion.ERROR_GET_ACTIVITY_LOG
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
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Unknown
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_add
import replyradar.composeapp.generated.resources.ic_archive
import replyradar.composeapp.generated.resources.ic_check
import replyradar.composeapp.generated.resources.ic_delete
import replyradar.composeapp.generated.resources.ic_edit
import replyradar.composeapp.generated.resources.ic_email
import replyradar.composeapp.generated.resources.ic_language
import replyradar.composeapp.generated.resources.ic_notification
import replyradar.composeapp.generated.resources.ic_open
import replyradar.composeapp.generated.resources.ic_rate
import replyradar.composeapp.generated.resources.ic_reopen
import replyradar.composeapp.generated.resources.ic_theme
import replyradar.composeapp.generated.resources.ic_time
import replyradar.composeapp.generated.resources.ic_unarchive

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivityLogScreen(viewModel: ActivityLogViewModel = koinViewModel(), onBackClick: () -> Unit) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = LocalReplyRadarStrings.current.activityLogTitle) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = LocalReplyRadarStrings.current
                                .activityLogBackButton
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingMedium)
                .background(colorScheme.background),
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                when {
                    state.isLoading -> Loading()
                    state.errorMessage != null -> Error(state)
                    state.activityLogItems.isEmpty() -> Placeholder()
                    else -> ActivityLogList(state)
                }
            }
        }
    }
}

@Composable
private fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ReplyProgress()
    }
}

@Composable
private fun Error(state: ActivityLogState) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ReplyRadarError(
            errorMessage = getErrorMessage(state.errorMessage)
        )
    }
}

@Composable
private fun Placeholder() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ReplyRadarPlaceholder(
            message = LocalReplyRadarStrings.current.activityLogPlaceholder
        )
    }
}

@Composable
private fun ActivityLogList(state: ActivityLogState) {
    LazyColumn(horizontalAlignment = CenterHorizontally) {
        itemsIndexed(
            state.activityLogItems,
            key = { _, item -> item.id }
        ) { index, userAction ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ActivityLogListItem(userAction = userAction)

                if (index < state.activityLogItems.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(paddingMedium),
                        thickness = listDividerThickness,
                        color = colorScheme.horizontalDividerColor
                    )
                } else {
                    Spacer(
                        modifier = Modifier
                            .height(paddingMedium)
                    )
                }
            }
        }
    }
}

@Composable
fun ActivityLogListItem(userAction: UserAction) {
    Surface(
        color = colorScheme.background
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = paddingMedium)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = CenterVertically,
            horizontalArrangement = spacedBy(paddingMedium)
        ) {
            with(userAction) {
                if (actionType != Unknown) {
                    Column {
                        Icon(
                            modifier = Modifier
                                .size(iconSize),
                            painter = painterResource(
                                getIconByActionType(
                                    actionType = actionType,
                                    targetType = targetType
                                )
                            ),
                            tint = colorScheme.primary,
                            contentDescription = LocalReplyRadarStrings.current
                                .activityLogItemContentDescription
                        )
                    }

                    Column {
                        Text(
                            text = formatUserActionLabel(
                                actionType = actionType,
                                targetType = targetType,
                                targetName = targetName
                            ),
                            style = typography.bodyMedium
                        )
                        Text(
                            text = formatTimestamp(createdAt),
                            style = typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun getErrorMessage(errorMessage: String?) = when (errorMessage) {
    ERROR_GET_ACTIVITY_LOG -> LocalReplyRadarStrings.current.activityLogGetActivityLogsError
    else -> LocalReplyRadarStrings.current.genericErrorMessage
}

private fun getIconByActionType(actionType: UserActionType, targetType: UserActionTargetType) =
    when (targetType) {
        Language -> drawable.ic_language
        Message -> when (actionType) {
            Archive -> drawable.ic_archive
            Create -> drawable.ic_add
            Delete -> drawable.ic_delete
            Edit -> drawable.ic_edit
            Reopen -> drawable.ic_reopen
            Resolve -> drawable.ic_check
            Unarchive -> drawable.ic_unarchive
            Open -> drawable.ic_open
            Scheduled -> drawable.ic_time
            OpenedNotification -> drawable.ic_notification
            Unknown -> {
                // no-op, this is just a icon placeholder for unknown actions

                drawable.ic_add
            }
        }

        Theme -> drawable.ic_theme
        Feedback -> drawable.ic_email
        Rate -> drawable.ic_rate
    }

@Composable
fun formatUserActionLabel(
    actionType: UserActionType,
    targetType: UserActionTargetType,
    targetName: String?
) = when (targetType) {
    Language -> LocalReplyRadarStrings.current.activityLogUserActionLanguage
    Message -> {
        format(
            LocalReplyRadarStrings.current.activityLogMessageFormat,
            getActionVerb(actionType),
            formatTargetName(targetName)
        )
    }

    Theme -> LocalReplyRadarStrings.current.activityLogUserActionTheme
    Feedback -> LocalReplyRadarStrings.current.activityLogUserActionFeedback
    Rate -> LocalReplyRadarStrings.current.activityLogUserActionRate
}

@Composable
private fun getActionVerb(actionType: UserActionType) = when (actionType) {
    Archive -> LocalReplyRadarStrings.current.activityLogUserActionArchiveVerb
    Create -> LocalReplyRadarStrings.current.activityLogUserActionCreateVerb
    Delete -> LocalReplyRadarStrings.current.activityLogUserActionDeleteVerb
    Edit -> LocalReplyRadarStrings.current.activityLogUserActionEditVerb
    Reopen -> LocalReplyRadarStrings.current.activityLogUserActionReopenVerb
    Resolve -> LocalReplyRadarStrings.current.activityLogUserActionResolveVerb
    Unarchive -> LocalReplyRadarStrings.current.activityLogUserActionUnarchiveVerb
    Open -> LocalReplyRadarStrings.current.activityLogUserActionOpenVerb
    Scheduled -> LocalReplyRadarStrings.current.activityLogUserActionScheduledVerb
    OpenedNotification -> LocalReplyRadarStrings.current.activityLogUserActionOpenedNotificationVerb
    Unknown -> EMPTY
}

@Composable
fun formatTargetName(name: String?): String {
    return name?.let { format(LocalReplyRadarStrings.current.activityLogMessageItem, it) }
        ?: LocalReplyRadarStrings.current.activityLogMessageItemRemoved
}
