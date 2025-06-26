package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.AppConstants.INITIAL_DATE
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.util.format
import com.rafaelfelipeac.replyradar.core.util.datetime.formatTimestamp
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState


@Composable
fun ColumnScope.ReplyTimestampInfo(
    state: ReplyBottomSheetState
) {
    state.reply?.let { reply ->
        Text(
            modifier = Modifier
                .padding(start = paddingSmall, top = paddingSmall)
                .align(Start),
            text = getTimestampInfo(reply),
            style = typography.bodySmall
        )
    }
}

@Composable
private fun getTimestampInfo(reply: Reply): String {
    with(reply) {
        return when {
            archivedAt != INITIAL_DATE -> format(
                LocalReplyRadarStrings.current.replyListItemArchivedAt,
                formatTimestamp(archivedAt)
            )

            resolvedAt != INITIAL_DATE -> format(
                LocalReplyRadarStrings.current.replyListItemResolvedAt,
                formatTimestamp(resolvedAt)
            )

            else -> {
                if (updatedAt != INITIAL_DATE && updatedAt != createdAt) {
                    format(
                        LocalReplyRadarStrings.current.replyListItemUpdatedAt,
                        formatTimestamp(updatedAt)
                    )
                } else {
                    format(
                        LocalReplyRadarStrings.current.replyListItemCreatedAt,
                        formatTimestamp(createdAt)
                    )
                }
            }
        }
    }
}
