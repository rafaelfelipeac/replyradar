package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListState
import org.jetbrains.compose.resources.stringResource
import replyradar.composeapp.generated.resources.Res.string
import replyradar.composeapp.generated.resources.reply_list_placeholder_resolved

@Composable
fun RepliesResolvedScreen(
    state: ReplyListState,
    onIntent: (ReplyListScreenIntent) -> Unit
) {
    if (state.resolvedReplies.isEmpty()) {
        Text(
            modifier = Modifier
                .padding(horizontal = paddingMedium),
            text = stringResource(string.reply_list_placeholder_resolved),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall
        )
    } else {
        ReplyList(
            modifier = Modifier.fillMaxSize(),
            replies = state.resolvedReplies,
            onReplyClick = {
                onIntent(OnReplyClick(it))
            }
        )
    }
}
