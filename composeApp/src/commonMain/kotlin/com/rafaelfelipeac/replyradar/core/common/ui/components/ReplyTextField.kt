package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.rafaelfelipeac.replyradar.core.common.ui.AccentColor
import com.rafaelfelipeac.replyradar.core.common.ui.FocusedTextFieldContainerColor
import com.rafaelfelipeac.replyradar.core.common.ui.UnfocusedTextFieldContainerColor
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall

@Composable
fun ReplyTextField(
    placeholder: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = paddingSmall),
        value = placeholder,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = FocusedTextFieldContainerColor,
            unfocusedContainerColor = UnfocusedTextFieldContainerColor,
            focusedLabelColor = AccentColor,
            focusedIndicatorColor = AccentColor,
            cursorColor = AccentColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Sentences
        ),
        onValueChange = { onValueChange(it) },
        label = { Text(label) }
    )
}