package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyProgress
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyToggle
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState

@Composable
fun RepliesOnTheRadarScreen(state: ReplyListState, onIntent: (ReplyListScreenIntent) -> Unit) {
    if (state.isLoading) {
        ReplyProgress()
    } else {
        when {
            state.errorMessage != null -> {
                Text(
                    text = state.errorMessage,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            state.replies.isEmpty() -> {
                Text(
                    modifier = Modifier
                        .padding(horizontal = paddingMedium),
                    text = LocalReplyRadarStrings.current.replyListPlaceholderOnTheRadar,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            else -> {
                ReplyList(
                    modifier = Modifier.fillMaxSize(),
                    replies = state.replies,
                    onReplyClick = { onIntent(OnReplyClick(it)) },
                    onReplyToggle = { onIntent(OnReplyToggle(it)) }
                )
            }
        }
    }
}
