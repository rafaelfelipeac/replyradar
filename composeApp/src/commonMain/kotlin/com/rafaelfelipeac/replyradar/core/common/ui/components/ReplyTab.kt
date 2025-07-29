package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelfelipeac.replyradar.core.common.ui.tabVerticalPadding
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme
import com.rafaelfelipeac.replyradar.core.theme.unselectedTabColor

@Composable
fun ReplyTab(modifier: Modifier, selected: Boolean, onClick: () -> Unit, text: String) {
    Tab(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        selectedContentColor = colorScheme.secondary,
        unselectedContentColor = colorScheme.unselectedTabColor
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = tabVerticalPadding),
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyTabPreview() {
    ReplyRadarTheme {
        ReplyTab(
            modifier = Modifier,
            selected = true,
            onClick = {},
            text = "Tab"
        )
    }
}
