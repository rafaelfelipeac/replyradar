package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.fontSizeLarge
import com.rafaelfelipeac.replyradar.core.common.ui.iconSize
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.theme.toolbarIconsColor
import org.jetbrains.compose.resources.painterResource
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_settings

@Composable
fun TopBar(onActivityLogClick: () -> Unit, onSettingsClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .padding(top = paddingMedium, start = paddingMedium)
                .align(Alignment.CenterStart)
                .clickable { onActivityLogClick() },
            textAlign = TextAlign.Center,
            text = LocalReplyRadarStrings.current.replyListActivityLog,
            style = typography.bodySmall,
            color = colorScheme.toolbarIconsColor
        )

        Text(
            modifier = Modifier
                .padding(top = paddingMedium)
                .align(Alignment.Center),
            textAlign = TextAlign.Center,
            text = LocalReplyRadarStrings.current.appName,
            style = typography.titleLarge.copy(fontSize = fontSizeLarge),
            color = colorScheme.onBackground
        )

        IconButton(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(top = paddingMedium, end = paddingMedium),
            onClick = { onSettingsClick() }
        ) {
            Icon(
                modifier = Modifier
                    .size(iconSize),
                painter = painterResource(drawable.ic_settings),
                contentDescription = LocalReplyRadarStrings.current.settingsTitle,
                tint = colorScheme.toolbarIconsColor
            )
        }
    }
}
