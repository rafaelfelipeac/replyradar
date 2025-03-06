package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply

@Composable
fun ReplyList(
    replies: List<Reply>,
    onReplyClick: (Reply) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .padding(top = 16.dp),
        verticalArrangement = spacedBy(12.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        items(
            items = replies,
            key = { it.id }
        ) { reply ->
            ReplyListItem(
                reply = reply,
                modifier = Modifier
                    .widthIn(max = 700.dp)
                    .fillMaxWidth(),
                onClick = {
                    onReplyClick(reply)
                }
            )
        }
    }
}