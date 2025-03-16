package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.rafaelfelipeac.replyradar.core.common.ui.ListItemColor
import com.rafaelfelipeac.replyradar.core.common.ui.PrimaryColor
import com.rafaelfelipeac.replyradar.core.common.ui.cardBorderWidth
import com.rafaelfelipeac.replyradar.core.common.ui.cardIconSize
import com.rafaelfelipeac.replyradar.core.common.ui.cardItemCornerRadius
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

private const val WEIGHT = 1f
private const val MAX_LINES = 1

@Composable
fun ReplyListItem(
    modifier: Modifier = Modifier,
    reply: Reply,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(cardItemCornerRadius),
        border = BorderStroke(cardBorderWidth, PrimaryColor),
        color = ListItemColor
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
                with(reply) {
                    ReplyListItemLabel(label = name)

                    if (subject.isNotEmpty()) {
                        ReplyListItemLabel(
                            label = subject,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            Icon(
                modifier = Modifier
                    .size(cardIconSize),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = PrimaryColor
            )
        }
    }
}

@Composable
fun ReplyListItemLabel(label: String, style: TextStyle = MaterialTheme.typography.titleMedium) {
    Text(
        text = label,
        style = style,
        maxLines = MAX_LINES,
        overflow = TextOverflow.Ellipsis
    )
}
