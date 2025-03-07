package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.rafaelfelipeac.replyradar.core.presentation.RichLavender
import com.rafaelfelipeac.replyradar.core.presentation.cardBorderWidth
import com.rafaelfelipeac.replyradar.core.presentation.cardIconSize
import com.rafaelfelipeac.replyradar.core.presentation.paddingMedium
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply

private const val WEIGHT = 1f
private const val MAX_LINES = 1

@Composable
fun ReplyListItem(
    reply: Reply,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(paddingMedium),
        border = BorderStroke(cardBorderWidth, RichLavender),
        modifier = modifier
            .clickable(onClick = onClick),
    ) {
        Row(
            modifier = Modifier
                .padding(paddingMedium)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            verticalAlignment = CenterVertically,
            horizontalArrangement = spacedBy(paddingMedium)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(WEIGHT),
                verticalArrangement = Center
            ) {
                Text(
                    text = reply.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = MAX_LINES,
                    overflow = TextOverflow.Ellipsis
                )

                if (reply.subject.isNotEmpty()) {
                    Text(
                        text = reply.subject,
                        style = MaterialTheme.typography.labelMedium,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = RichLavender,
                modifier = Modifier
                    .size(cardIconSize)
            )
        }
    }
}