package com.rafaelfelipeac.replyradar.platform.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.platform.ui.AccentColor
import com.rafaelfelipeac.replyradar.platform.ui.UnselectedTabColor
import com.rafaelfelipeac.replyradar.platform.ui.tabVerticalPadding

@Composable
fun ReplyTab(
    modifier: Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    text: String
) {
    Tab(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        selectedContentColor = AccentColor,
        unselectedContentColor = UnselectedTabColor
    ) {
        Text(
            modifier = Modifier
                .padding(vertical = tabVerticalPadding),
            text = text,
        )
    }
}
