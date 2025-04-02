package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.rafaelfelipeac.replyradar.core.common.ui.listDividerThickness
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

@Composable
fun ReplyList(modifier: Modifier = Modifier, replies: List<Reply>, onReplyClick: (Reply) -> Unit) {
    LazyColumn(
        modifier = modifier
            .padding(top = paddingMedium),
        horizontalAlignment = CenterHorizontally
    ) {
        itemsIndexed(replies, key = { _, item -> item.id }) { index, reply ->
            Column(modifier = Modifier.fillMaxWidth()) {
                ReplyListItem(
                    modifier = Modifier
                        .fillMaxWidth(),
                    reply = reply,
                    onClick = {
                        onReplyClick(reply)
                    }
                )

                if (index < replies.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(paddingMedium),
                        thickness = listDividerThickness,
                        color = Color.LightGray
                    )
                }
            }
        }
    }
}
