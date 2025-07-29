package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.rafaelfelipeac.replyradar.core.common.ui.cardCornerRadius
import com.rafaelfelipeac.replyradar.core.common.ui.empty
import com.rafaelfelipeac.replyradar.core.common.ui.previewSize
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Composable
fun ReplyRoundedCorner(cornerRadius: Dp = cardCornerRadius, onlyTopCorners: Boolean = false) =
    RoundedCornerShape(
        topStart = cornerRadius,
        topEnd = cornerRadius,
        bottomStart = if (onlyTopCorners) empty else cornerRadius,
        bottomEnd = if (onlyTopCorners) empty else cornerRadius
    )

@Preview
@Composable
fun ReplyRoundedCornerPreview() {
    ReplyRadarTheme {
        Box(
            modifier = Modifier
                .size(previewSize)
                .background(
                    color = colorScheme.primary,
                    shape = ReplyRoundedCorner()
                )
        )
    }
}
