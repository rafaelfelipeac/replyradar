package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.util.AppConstants.ARCHIVED_INDEX
import com.rafaelfelipeac.replyradar.core.util.AppConstants.ON_THE_RADAR_INDEX
import com.rafaelfelipeac.replyradar.core.util.AppConstants.RESOLVED_INDEX
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState

@Composable
fun RepliesScreen(
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
