package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.listDividerThickness
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.theme.horizontalDividerColor
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

@Composable
fun ReplyList(
    modifier: Modifier = Modifier,
    replies: List<Reply>,
    onReplyClick: (Reply) -> Unit,
    onReplyToggle: ((Reply) -> Unit?)? = null
) {
    LazyColumn(
        modifier = modifier
            .padding(top = paddingMedium),
        horizontalAlignment = CenterHorizontally
    ) {
        itemsIndexed(items = replies, key = { _, item -> item.id }) { index, reply ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                ReplyListItem(
                    modifier = Modifier
                        .fillMaxWidth(),
                    reply = reply,
                    onClick = { onReplyClick(reply) },
                    onToggle = { onReplyToggle?.let { onReplyToggle(reply) } }
                )

                if (index < replies.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(paddingMedium),
                        thickness = listDividerThickness,
                        color = colorScheme.horizontalDividerColor
                    )
                } else {
                    Spacer(
                        modifier = Modifier
                            .height(paddingMedium)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyListPreview() {
    ReplyRadarTheme {
        ReplyList(
            replies = listOf(
                Reply(
                    id = 1,
                    message = "Message 1",
                    isResolved = false
                ),
                Reply(
                    id = 2,
                    message = "Message 2",
                    isResolved = false
                )
            ),
            onReplyClick = {}
        )
    }
}
