package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTab
import com.rafaelfelipeac.replyradar.core.common.ui.fontSizeLarge
import com.rafaelfelipeac.replyradar.core.common.ui.iconSize
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.spacerSmall
import com.rafaelfelipeac.replyradar.core.common.ui.tabRowTopPadding
import com.rafaelfelipeac.replyradar.core.common.ui.theme.toolbarIconsColor
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnAddReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnTabSelected
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesArchivedScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesOnTheRadarScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesResolvedScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheet
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_settings

private const val WEIGHT = 1f
private const val PAGER_PAGE_COUNT = 3
private const val ON_THE_RADAR_INDEX = 0
private const val RESOLVED_INDEX = 1
private const val ARCHIVED_INDEX = 2

@Composable
fun ReplyListScreenRoot(
    viewModel: ReplyListViewModel = koinViewModel(),
    onSettingsClick: () -> Unit,
    onActivityLogClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ReplyListScreen(
        state = state,
        onIntent = { intent ->
            viewModel.onIntent(intent)
        },
        onSettingsClick = onSettingsClick,
        onActivityLogClick = onActivityLogClick
    )
}

@Composable
fun ReplyListScreen(
    state: ReplyListState,
    onIntent: (ReplyListScreenIntent) -> Unit,
    onSettingsClick: () -> Unit,
    onActivityLogClick: () -> Unit
) {
    val pagerState = rememberPagerState { PAGER_PAGE_COUNT }

    LaunchedEffect(state.selectedTabIndex) {
        pagerState.animateScrollToPage(state.selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        onIntent(OnTabSelected(pagerState.currentPage))
    }

    Scaffold(
        containerColor = colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onIntent(OnAddReplyClick) },
                containerColor = colorScheme.secondary
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription =
                    LocalReplyRadarStrings.current.replyListFabContentDescription,
                    tint = colorScheme.background
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding())
                .statusBarsPadding()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = paddingMedium, start = paddingMedium)
                        .align(Alignment.CenterStart)
                        .clickable { onActivityLogClick() },
                    textAlign = TextAlign.Center,
                    text = LocalReplyRadarStrings.current.replyListActivityLog,
                    style = MaterialTheme.typography.bodySmall,
                    color = colorScheme.toolbarIconsColor
                )

                Text(
                    modifier = Modifier
                        .padding(top = paddingMedium)
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                    text = LocalReplyRadarStrings.current.appName,
                    style = MaterialTheme.typography.titleLarge.copy(fontSize = fontSizeLarge),
                    color = colorScheme.onBackground
                )

                IconButton(
                    onClick = { onSettingsClick() },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(top = paddingMedium, end = paddingMedium)
                ) {
                    Icon(
                        modifier = Modifier
                            .size(iconSize),
                        painter = painterResource(drawable.ic_settings),
                        contentDescription = LocalReplyRadarStrings.current.settingsTitle,
                        tint = colorScheme.toolbarIconsColor
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .weight(WEIGHT)
                    .fillMaxWidth(),
                color = colorScheme.background
            ) {
                Column(
                    horizontalAlignment = CenterHorizontally
                ) {
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
                            modifier = Modifier.weight(WEIGHT),
                            selected = state.selectedTabIndex == ON_THE_RADAR_INDEX,
                            onClick = { onIntent(OnTabSelected(ON_THE_RADAR_INDEX)) },
                            text = LocalReplyRadarStrings.current.replyListTabOnTheRadar
                        )

                        ReplyTab(
                            modifier = Modifier.weight(WEIGHT),
                            selected = state.selectedTabIndex == RESOLVED_INDEX,
                            onClick = { onIntent(OnTabSelected(RESOLVED_INDEX)) },
                            text = LocalReplyRadarStrings.current.replyListTabResolved
                        )

                        ReplyTab(
                            modifier = Modifier.weight(WEIGHT),
                            selected = state.selectedTabIndex == ARCHIVED_INDEX,
                            onClick = { onIntent(OnTabSelected(ARCHIVED_INDEX)) },
                            text = LocalReplyRadarStrings.current.replyListTabArchived
                        )
                    }

                    Spacer(modifier = Modifier.height(spacerSmall))

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
                onIntent = onIntent,
                replyBottomSheetState = state.replyBottomSheetState
            )
        }
    }
}

@Composable
private fun RepliesScreen(
    pageIndex: Int,
    state: ReplyListState,
    onIntent: (ReplyListScreenIntent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.background),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when (pageIndex) {
                    ON_THE_RADAR_INDEX -> RepliesOnTheRadarScreen(
                        state = state,
                        onIntent = onIntent
                    )

                    RESOLVED_INDEX -> RepliesResolvedScreen(
                        state = state,
                        onIntent = onIntent
                    )

                    ARCHIVED_INDEX -> RepliesArchivedScreen(
                        state = state,
                        onIntent = onIntent
                    )
                }
            }
        }
    }
}
