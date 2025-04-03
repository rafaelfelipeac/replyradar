package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.common.ui.Background
import com.rafaelfelipeac.replyradar.core.common.ui.ButtonBorderColor
import com.rafaelfelipeac.replyradar.core.common.ui.PrimaryColor
import com.rafaelfelipeac.replyradar.core.common.ui.buttonBorderWidth
import com.rafaelfelipeac.replyradar.core.common.ui.buttonCornerRadius
import com.rafaelfelipeac.replyradar.core.common.ui.buttonHeight
import com.rafaelfelipeac.replyradar.core.common.ui.buttonIconSize
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ReplyOutlinedButton(text: String, icon: DrawableResource? = null, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .height(buttonHeight)
            .padding(horizontal = paddingXSmall),
        onClick = onClick,
        shape = RoundedCornerShape(buttonCornerRadius),
        border = BorderStroke(buttonBorderWidth, ButtonBorderColor),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Background,
            contentColor = PrimaryColor
        ),
        contentPadding = PaddingValues(horizontal = paddingSmall, vertical = paddingXSmall)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = paddingXSmall),
            text = text
        )
        icon?.let { icon ->
            Icon(
                modifier = Modifier
                    .size(buttonIconSize),
                painter = painterResource(icon),
                tint = PrimaryColor,
                contentDescription = text
            )
        }
    }
}
