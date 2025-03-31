package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.rafaelfelipeac.replyradar.core.common.ui.cardCornerRadius

@Composable
fun ReplyRoundedCorner(cornerRadius: Dp = cardCornerRadius) = RoundedCornerShape(
    topStart = cornerRadius,
    topEnd = cornerRadius,
    bottomStart = cornerRadius,
    bottomEnd = cornerRadius
)
