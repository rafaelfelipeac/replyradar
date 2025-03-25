package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelfelipeac.replyradar.core.common.ui.AccentColor
import com.rafaelfelipeac.replyradar.core.common.ui.DesertWhite
import com.rafaelfelipeac.replyradar.core.common.ui.PrimaryColor
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyRoundedCorner
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTab
import com.rafaelfelipeac.replyradar.core.common.ui.paddingLarge
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.spacerSmall
import com.rafaelfelipeac.replyradar.core.common.ui.tabRowTopPadding
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnAddReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnTabSelected
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesArchivedScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesOnTheRadarScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.RepliesResolvedScreen
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheet
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import replyradar.composeapp.generated.resources.Res.string
import replyradar.composeapp.generated.resources.reply_list_fab_content_description
import replyradar.composeapp.generated.resources.reply_list_tab_archived
import replyradar.composeapp.generated.resources.reply_list_tab_on_the_radar
import replyradar.composeapp.generated.resources.reply_list_tab_resolved

private const val WEIGHT = 1f
private const val PAGER_PAGE_COUNT = 3
private const val ON_THE_RADAR_INDEX = 0
private const val RESOLVED_INDEX = 1
private const val ARCHIVED_INDEX = 2

@Composable
fun ReplyListScreenRoot(
    viewModel: ReplyListViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ReplyListScreen(
        state = state,
        onIntent = { intent ->
            viewModel.onIntent(intent)
        }
    )
}

@Composable
fun ReplyListScreen(
    state: ReplyListState,
    onIntent: (ReplyListScreenIntent) -> Unit
) {
    val pagerState = rememberPagerState { PAGER_PAGE_COUNT }

    LaunchedEffect(state.selectedTabIndex) {
        pagerState.animateScrollToPage(state.selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        onIntent(OnTabSelected(pagerState.currentPage))
    }

    Scaffold(
        containerColor = PrimaryColor,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onIntent(OnAddReplyClick) },
                containerColor = AccentColor
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(string.reply_list_fab_content_description),
                    tint = DesertWhite
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .statusBarsPadding()
        ) {
            Surface(
                modifier = Modifier
                    .weight(WEIGHT)
                    .padding(top = paddingLarge)
                    .fillMaxWidth(),
                color = DesertWhite,
                shape = ReplyRoundedCorner()
            ) {
                Column(
                    horizontalAlignment = CenterHorizontally
                ) {
                    TabRow(
                        modifier = Modifier
                            .padding(top = tabRowTopPadding)
                            .fillMaxWidth(),
                        selectedTabIndex = state.selectedTabIndex,
                        containerColor = DesertWhite,
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                modifier = Modifier
                                    .tabIndicatorOffset(tabPositions[state.selectedTabIndex]),
                                color = AccentColor
                            )
                        }
                    ) {
                        ReplyTab(
                            modifier = Modifier.weight(WEIGHT),
                            selected = state.selectedTabIndex == ON_THE_RADAR_INDEX,
                            onClick = { onIntent(OnTabSelected(ON_THE_RADAR_INDEX)) },
                            text = stringResource(string.reply_list_tab_on_the_radar)
                        )

                        ReplyTab(
                            modifier = Modifier.weight(WEIGHT),
                            selected = state.selectedTabIndex == RESOLVED_INDEX,
                            onClick = { onIntent(OnTabSelected(RESOLVED_INDEX)) },
                            text = stringResource(string.reply_list_tab_resolved)
                        )

                        ReplyTab(
                            modifier = Modifier.weight(WEIGHT),
                            selected = state.selectedTabIndex == ARCHIVED_INDEX,
                            onClick = { onIntent(OnTabSelected(ARCHIVED_INDEX)) },
                            text = stringResource(string.reply_list_tab_archived)
                        )
                    }

                    Spacer(modifier = Modifier.height(spacerSmall))

                    HorizontalPager(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(WEIGHT),
                        state = pagerState
                    ) { pageIndex ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = paddingMedium),
                            contentAlignment = Alignment.Center
                        ) {
                            when (pageIndex) {
                                ON_THE_RADAR_INDEX -> RepliesOnTheRadarScreen(state, onIntent)
                                RESOLVED_INDEX -> RepliesResolvedScreen(state, onIntent)
                                ARCHIVED_INDEX -> RepliesArchivedScreen(state, onIntent)
                            }
                        }
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
