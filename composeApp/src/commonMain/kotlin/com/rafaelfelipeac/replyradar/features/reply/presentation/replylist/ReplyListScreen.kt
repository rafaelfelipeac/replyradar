package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelfelipeac.replyradar.core.AppConstants.INITIAL_DATE
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.strings.Strings
import com.rafaelfelipeac.replyradar.core.common.ui.components.NotificationPermissionDialog
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplySnackbar
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTab
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.spacerXSmall
import com.rafaelfelipeac.replyradar.core.common.ui.tabRowTopPadding
import com.rafaelfelipeac.replyradar.core.notification.LocalNotificationPermissionManager
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.CheckNotificationPermission
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.GoToSettings
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.RequestNotificationPermission
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Archived
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Removed
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Reopened
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Resolved
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListEffect.SnackbarState.Unarchived
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent.OnCheckNotificationPermission
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent.OnGoToSettings
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.NotificationPermissionIntent.OnRequestNotificationPermission
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnAddOrEditReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDeleteReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDismissBottomSheet
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleArchive
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleResolve
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnTabSelected
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.FloatingActionButton
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.TopBar
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheet
import kotlinx.coroutines.flow.Flow
import org.koin.compose.viewmodel.koinViewModel

private const val WEIGHT = 1f
private const val PAGER_PAGE_COUNT = 3
const val ON_THE_RADAR_INDEX = 0
const val RESOLVED_INDEX = 1
const val ARCHIVED_INDEX = 2

@Composable
fun ReplyListScreenRoot(
    viewModel: ReplyListViewModel = koinViewModel(),
    onSettingsClick: () -> Unit,
    onActivityLogClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val effect = viewModel.effect

    ReplyListScreen(
        state = state,
        effect = effect,
        onIntent = { intent ->
            viewModel.onIntent(intent)
        },
        onSettingsClick = onSettingsClick,
        onActivityLogClick = onActivityLogClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyListScreen(
    state: ReplyListState,
    effect: Flow<ReplyListEffect>,
    onIntent: (ReplyListScreenIntent) -> Unit,
    onSettingsClick: () -> Unit,
    onActivityLogClick: () -> Unit
) {
    val strings = LocalReplyRadarStrings.current
    val notificationPermissionManager = LocalNotificationPermissionManager.current

    val pagerState = rememberPagerState { PAGER_PAGE_COUNT }
    val snackbarHostState = remember { SnackbarHostState() }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var showPermissionDialog by remember { mutableStateOf(false) }

    LaunchedEffect(pagerState.currentPage) {
        onIntent(OnTabSelected(pagerState.currentPage))
    }

    LaunchedEffect(state.selectedTabIndex) {
        pagerState.animateScrollToPage(state.selectedTabIndex)
    }

    LaunchedEffect(Unit) {
        effect.collect { effect ->
            when (effect) {
                is SnackbarState -> snackbarHostState.showSnackbar(
                    getSnackbarMessage(
                        effect,
                        strings
                    )
                )

                RequestNotificationPermission -> showPermissionDialog = true


                GoToSettings -> notificationPermissionManager.goToAppSettings()

                is CheckNotificationPermission -> {
                    when {
                        notificationPermissionManager.ensureNotificationPermission() -> {
                            onIntent(OnAddOrEditReply(effect.reply))
                        }

                        else -> onIntent(OnRequestNotificationPermission)
                    }
                }
            }
        }
    }

    if (showPermissionDialog) {
        NotificationPermissionDialog(
            onDismiss = { showPermissionDialog = false },
            onGoToSettings = {
                showPermissionDialog = false
                onIntent(OnGoToSettings)
            }
        )
    }

    Scaffold(
        containerColor = colorScheme.background,
        snackbarHost = { ReplySnackbar(snackbarHostState) },
        floatingActionButton = { FloatingActionButton(onIntent, colorScheme) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .statusBarsPadding()
        ) {
            TopBar(onActivityLogClick = onActivityLogClick, onSettingsClick = onSettingsClick)

            Surface(
                modifier = Modifier
                    .weight(WEIGHT)
                    .fillMaxWidth(),
                color = colorScheme.background
            ) {
                Column(horizontalAlignment = CenterHorizontally) {
                    TabRow(
                        modifier = Modifier
                            .padding(
                                start = paddingMedium,
                                top = tabRowTopPadding,
                                end = paddingMedium
                            )
                            .fillMaxWidth(),
                        selectedTabIndex = state.selectedTabIndex,
                        containerColor = colorScheme.background,
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                modifier = Modifier
                                    .tabIndicatorOffset(tabPositions[state.selectedTabIndex]),
                                color = colorScheme.secondary
                            )
                        }
                    ) {
                        ReplyTab(
                            modifier = Modifier
                                .weight(WEIGHT),
                            selected = state.selectedTabIndex == ON_THE_RADAR_INDEX,
                            onClick = { onIntent(OnTabSelected(ON_THE_RADAR_INDEX)) },
                            text = LocalReplyRadarStrings.current.replyListTabOnTheRadar
                        )

                        ReplyTab(
                            modifier = Modifier
                                .weight(WEIGHT),
                            selected = state.selectedTabIndex == RESOLVED_INDEX,
                            onClick = { onIntent(OnTabSelected(RESOLVED_INDEX)) },
                            text = LocalReplyRadarStrings.current.replyListTabResolved
                        )

                        ReplyTab(
                            modifier = Modifier
                                .weight(WEIGHT),
                            selected = state.selectedTabIndex == ARCHIVED_INDEX,
                            onClick = { onIntent(OnTabSelected(ARCHIVED_INDEX)) },
                            text = LocalReplyRadarStrings.current.replyListTabArchived
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .height(spacerXSmall)
                    )

                    HorizontalPager(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(WEIGHT),
                        state = pagerState
                    ) { pageIndex ->
                        RepliesScreen(pageIndex = pageIndex, state = state, onIntent = onIntent)
                    }
                }
            }
        }

        if (state.replyBottomSheetState != null) {
            ReplyBottomSheet(
                sheetState = sheetState,
                onResolve = { onIntent(OnToggleResolve(it)) },
                onArchive = { onIntent(OnToggleArchive(it)) },
                onDelete = { onIntent(OnDeleteReply(it)) },
                onSave = { reply ->
                    when {
                        reply.reminderAt != INITIAL_DATE -> {
                            onIntent(OnCheckNotificationPermission(reply))
                        }

                        else -> onIntent(OnAddOrEditReply(reply))
                    }
                },
                onDismiss = { onIntent(OnDismissBottomSheet) },
                replyBottomSheetState = state.replyBottomSheetState,
            )
        }
    }
}

private fun getSnackbarMessage(
    effect: SnackbarState,
    strings: Strings
) = when (effect) {
    Archived -> strings.replyListSnackbarArchived
    Removed -> strings.replyListSnackbarRemoved
    Reopened -> strings.replyListSnackbarReopened
    Resolved -> strings.replyListSnackbarResolved
    Unarchived -> strings.replyListSnackbarUnarchived
}
