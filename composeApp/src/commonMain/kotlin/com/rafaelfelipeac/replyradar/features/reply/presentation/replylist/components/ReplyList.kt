package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.replyListVerticalPadding
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

@Composable
fun ReplyList(modifier: Modifier = Modifier, replies: List<Reply>, onReplyClick: (Reply) -> Unit) {
    LazyColumn(
        modifier = modifier
            .padding(top = paddingSmall),
        verticalArrangement = spacedBy(replyListVerticalPadding),
        horizontalAlignment = CenterHorizontally
    ) {
        items(
            items = replies,
            key = { it.id }
        ) { reply ->
            ReplyListItem(
                modifier = Modifier
                    .fillMaxWidth(),
                reply = reply,
                onClick = {
                    onReplyClick(reply)
                }
            )
        }
    }
}
