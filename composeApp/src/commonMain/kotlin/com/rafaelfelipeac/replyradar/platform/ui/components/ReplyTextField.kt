package com.rafaelfelipeac.replyradar.platform.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.rafaelfelipeac.replyradar.platform.ui.FocusedTextFieldContainerColor
import com.rafaelfelipeac.replyradar.platform.ui.UnfocusedTextFieldContainerColor
import com.rafaelfelipeac.replyradar.platform.ui.AccentColor
import com.rafaelfelipeac.replyradar.platform.ui.paddingMedium

@Composable
fun ReplyTextField(
    placeholder: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = paddingMedium),
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