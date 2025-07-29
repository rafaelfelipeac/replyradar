package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.buttonBorderWidth
import com.rafaelfelipeac.replyradar.core.common.ui.buttonCornerRadius
import com.rafaelfelipeac.replyradar.core.common.ui.buttonHeight
import com.rafaelfelipeac.replyradar.core.common.ui.iconSize
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.theme.buttonBorderColor
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import replyradar.composeapp.generated.resources.Res
import replyradar.composeapp.generated.resources.ic_calendar
import replyradar.composeapp.generated.resources.ic_clock

@Composable
fun ReplyOutlinedButton(text: String, icon: DrawableResource? = null, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .height(buttonHeight)
            .padding(horizontal = paddingXSmall),
        onClick = onClick,
        shape = RoundedCornerShape(buttonCornerRadius),
        border = BorderStroke(buttonBorderWidth, colorScheme.buttonBorderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = colorScheme.background,
            contentColor = colorScheme.primary
        ),
        contentPadding = PaddingValues(horizontal = paddingSmall, vertical = paddingXSmall)
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = paddingXSmall),
            text = text
        )
        icon?.let { icon ->
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = painterResource(icon),
                tint = colorScheme.primary,
                contentDescription = text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonPreview() {
    ReplyRadarTheme {
        ReplyOutlinedButton(
            text = "September 11, 2024",
            icon = Res.drawable.ic_calendar,
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonPreview2() {
    ReplyRadarTheme {
        ReplyOutlinedButton(
            text = "10:30",
            icon = Res.drawable.ic_clock,
            onClick = {}
        )
    }
}
