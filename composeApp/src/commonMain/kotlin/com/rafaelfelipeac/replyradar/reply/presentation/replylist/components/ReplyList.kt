package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.ui.replyListVerticalPadding
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply

@Composable
fun ReplyList(
    replies: List<Reply>,
    onReplyClick: (Reply) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .padding(top = paddingMedium),
        verticalArrangement = spacedBy(replyListVerticalPadding),
        horizontalAlignment = CenterHorizontally
    ) {
        items(
            items = replies,
            key = { it.id }
        ) { reply ->
            ReplyListItem(
                reply = reply,
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    onReplyClick(reply)
                }
            )
        }
    }
}