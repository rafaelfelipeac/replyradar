package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.input.KeyboardCapitalization.Companion.Sentences
import androidx.compose.ui.unit.TextUnit
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextFieldSize.Large
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextFieldSize.Medium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.common.ui.textSizeLarge
import com.rafaelfelipeac.replyradar.core.common.ui.textSizeMedium
import com.rafaelfelipeac.replyradar.core.common.ui.textSizeSmall
import com.rafaelfelipeac.replyradar.core.theme.textFieldPlaceholderColor

@Composable
fun ReplyTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    textSize: ReplyTextFieldSize = Medium
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(colorScheme.background)
            .padding(horizontal = paddingSmall),
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        cursorBrush = SolidColor(colorScheme.primary),
        textStyle = TextStyle(
            fontSize = textSize.value,
            color = colorScheme.primary,
            fontWeight = if (value.isNotBlank() && textSize == Large) Bold else Normal
        ),
        keyboardOptions = KeyboardOptions(capitalization = Sentences),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = paddingXSmall)
            ) {
                if (value.isEmpty()) {
                    Box(
                        modifier = Modifier
                            .matchParentSize(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = placeholder,
                            color = colorScheme.textFieldPlaceholderColor,
                            fontSize = textSize.value
                        )
                    }
                }
                innerTextField()
            }
        }
    )
}

sealed class ReplyTextFieldSize(val value: TextUnit) {
    data object Small : ReplyTextFieldSize(textSizeSmall)
    data object Medium : ReplyTextFieldSize(textSizeMedium)
    data object Large : ReplyTextFieldSize(textSizeLarge)
}
