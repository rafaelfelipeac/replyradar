package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.rafaelfelipeac.replyradar.core.common.ui.cardCornerRadius
import com.rafaelfelipeac.replyradar.core.common.ui.empty

@Composable
fun ReplyRoundedCorner(cornerRadius: Dp = cardCornerRadius, onlyTopCorners: Boolean = false) =
    RoundedCornerShape(
        topStart = cornerRadius,
        topEnd = cornerRadius,
        bottomStart = if (onlyTopCorners) empty else cornerRadius,
        bottomEnd = if (onlyTopCorners) empty else cornerRadius,
    )
