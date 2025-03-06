package com.rafaelfelipeac.replyradar.reply.presentation.replylist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelfelipeac.replyradar.core.presentation.DeepSkyBlue
import com.rafaelfelipeac.replyradar.core.presentation.DesertWhite
import com.rafaelfelipeac.replyradar.core.presentation.RichLavender
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnAddReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnDeleteReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnEditReply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnReplyClick
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListAction.OnToggleResolve
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetContent
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.ReplyList
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode.EDIT
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import replyradar.composeapp.generated.resources.Res
import replyradar.composeapp.generated.resources.reply_list_fab_content_description
import replyradar.composeapp.generated.resources.reply_list_placeholder_archived
import replyradar.composeapp.generated.resources.reply_list_placeholder_on_the_radar
import replyradar.composeapp.generated.resources.reply_list_tab_resolved
import replyradar.composeapp.generated.resources.reply_list_tab_on_the_radar

@Composable
fun ReplyListScreenRoot(
    viewModel: ReplyListViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ReplyListScreen(
        state = state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReplyListScreen(
    state: ReplyListState,
    onAction: (ReplyListAction) -> Unit,
) {
    val pagerState = rememberPagerState { 2 }

    LaunchedEffect(state.selectedTabIndex) {
        pagerState.animateScrollToPage(state.selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        onAction(ReplyListAction.OnTabSelected(pagerState.currentPage))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepSkyBlue)
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                color = DesertWhite,
                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                )
            ) {
                Column(
                    horizontalAlignment = CenterHorizontally
                ) {
                    TabRow(
                        selectedTabIndex = state.selectedTabIndex,
                        modifier = Modifier
                            .padding(vertical = 12.dp)
                            .widthIn(max = 700.dp)
                            .fillMaxWidth(),
                        containerColor = DesertWhite,
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                color = RichLavender,
                                modifier = Modifier
                                    .tabIndicatorOffset(tabPositions[state.selectedTabIndex])
                            )
                        }
                    ) {
                        Tab(
                            selected = state.selectedTabIndex == 0,
                            onClick = {
                                onAction(ReplyListAction.OnTabSelected(0))
                            },
                            modifier = Modifier.weight(1f),
                            selectedContentColor = RichLavender,
                            unselectedContentColor = Color.Black.copy(alpha = 0.5f)
                        ) {
                            Text(
                                text = stringResource(Res.string.reply_list_tab_on_the_radar),
                                modifier = Modifier
                                    .padding(vertical = 12.dp)
                            )
                        }

                        Tab(
                            selected = state.selectedTabIndex == 1,
                            onClick = {
                                onAction(ReplyListAction.OnTabSelected(1))
                            },
                            modifier = Modifier.weight(1f),
                            selectedContentColor = RichLavender,
                            unselectedContentColor = Color.Black.copy(alpha = 0.5f)
                        ) {
                            Text(
                                text = stringResource(Res.string.reply_list_tab_resolved),
                                modifier = Modifier
                                    .padding(vertical = 12.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) { pageIndex ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            when (pageIndex) {
                                0 -> {
                                    if (state.isLoading) {
                                        CircularProgressIndicator()
                                    } else {
                                        when {
                                            state.errorMessage != null -> {
                                                Text(
                                                    text = state.errorMessage,
                                                    textAlign = TextAlign.Center,
                                                    style = MaterialTheme.typography.headlineSmall,
                                                    color = MaterialTheme.colorScheme.error
                                                )
                                            }

                                            state.replies.isEmpty() -> {
                                                Text(
                                                    text = stringResource(Res.string.reply_list_placeholder_on_the_radar),
                                                    textAlign = TextAlign.Center,
                                                    style = MaterialTheme.typography.headlineSmall,
                                                )
                                            }

                                            else -> {
                                                ReplyList(
                                                    replies = state.replies,
                                                    onReplyClick = {
                                                        onAction(OnReplyClick(it))
                                                    },
                                                    modifier = Modifier.fillMaxSize(),
                                                )
                                            }
                                        }
                                    }
                                }

                                1 -> {
                                    if (state.resolvedReplies.isEmpty()) {
                                        Text(
                                            text = stringResource(Res.string.reply_list_placeholder_archived),
                                            textAlign = TextAlign.Center,
                                            style = MaterialTheme.typography.headlineSmall,
                                        )
                                    } else {
                                        ReplyList(
                                            replies = state.resolvedReplies,
                                            onReplyClick = {
                                                onAction(OnReplyClick(it))
                                            },
                                            modifier = Modifier.fillMaxSize(),
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { onAction(ReplyListAction.OnAddReplyClick) },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = RichLavender
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = stringResource(Res.string.reply_list_fab_content_description),
                tint = Color.White
            )
        }

        if (state.bottomSheetState != null) {
            ModalBottomSheet(
                onDismissRequest = {
                    onAction(ReplyListAction.OnDismissBottomSheet)
                }
            ) {
                when (state.bottomSheetState.mode) {
                    CREATE -> {
                        BottomSheetContent(
                            mode = CREATE,
                            reply = null,
                            onComplete = { reply ->
                                onAction(OnAddReply(reply))
                            },
                            onResolve = { reply ->
                                onAction(OnToggleResolve(reply))
                            },
                            onDelete = { reply ->
                                onAction(OnDeleteReply((reply)))
                            }
                        )
                    }

                    EDIT -> {
                        if (state.bottomSheetState.reply != null) {
                            BottomSheetContent(
                                mode = EDIT,
                                reply = state.bottomSheetState.reply,
                                onComplete = { reply ->
                                    onAction(OnEditReply(reply))
                                },
                                onResolve = { reply ->
                                    onAction(OnToggleResolve(reply))
                                },
                                onDelete = { reply ->
                                    onAction(OnDeleteReply((reply)))
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
