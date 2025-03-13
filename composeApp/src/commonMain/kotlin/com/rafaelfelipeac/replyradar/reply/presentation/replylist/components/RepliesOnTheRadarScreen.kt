package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.rafaelfelipeac.replyradar.platform.ui.components.ReplyProgress
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyClick
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListState
import org.jetbrains.compose.resources.stringResource
import replyradar.composeapp.generated.resources.Res.string
import replyradar.composeapp.generated.resources.reply_list_placeholder_on_the_radar

@Composable
fun RepliesOnTheRadarScreen(
    state: ReplyListState,
    onIntent: (ReplyListScreenIntent) -> Unit
) {
    if (state.isLoading) {
        ReplyProgress()
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
                    text = stringResource(string.reply_list_placeholder_on_the_radar),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall,
                )
            }

            else -> {
                ReplyList(
                    modifier = Modifier.fillMaxSize(),
                    replies = state.replies,
                    onReplyClick = {
                        onIntent(OnReplyClick(it))
                    }
                )
            }
        }
    }
}