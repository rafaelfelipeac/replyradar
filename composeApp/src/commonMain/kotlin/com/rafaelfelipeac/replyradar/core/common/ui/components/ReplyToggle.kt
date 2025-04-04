package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion.LongPress
import androidx.compose.ui.platform.LocalHapticFeedback
import com.rafaelfelipeac.replyradar.core.common.ui.listItemResolveSize
import com.rafaelfelipeac.replyradar.core.common.ui.listItemToggleBorderWidth
import com.rafaelfelipeac.replyradar.core.common.ui.listItemToggleSize
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.Res.string
import replyradar.composeapp.generated.resources.ic_check
import replyradar.composeapp.generated.resources.reply_list_item_resolve

@Composable
fun ReplyToggle(modifier: Modifier = Modifier, isResolved: Boolean, onToggle: () -> Unit) {
    var localIsResolved by remember { mutableStateOf(isResolved) }
    val transition =
        updateTransition(targetState = localIsResolved, label = TOGGLE_TRANSITION_LABEL)
    val haptic = LocalHapticFeedback.current

    val checkIconAlpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = TOGGLE_ANIMATION_DURATION_MS) },
        label = CHECK_ICON_ALPHA_LABEL
    ) {
        if (it) ALPHA_VISIBLE else ALPHA_HIDDEN
    }

    val toggleBorderAlpha by transition.animateFloat(
        transitionSpec = { tween(durationMillis = TOGGLE_ANIMATION_DURATION_MS) },
        label = TOGGLE_BORDER_ALPHA_LABEL
    ) {
        if (it) ALPHA_HIDDEN else ALPHA_VISIBLE
    }

    Box(
        modifier = modifier
            .size(listItemToggleSize)
            .clip(CircleShape)
            .background(Transparent)
            .border(
                width = listItemToggleBorderWidth,
                color = colorScheme.primary.copy(alpha = toggleBorderAlpha),
                shape = CircleShape
            )
            .clickable {
                if (!localIsResolved) {
                    localIsResolved = true
                    haptic.performHapticFeedback(LongPress)
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(drawable.ic_check),
            contentDescription = stringResource(string.reply_list_item_resolve),
            tint = colorScheme.primary.copy(alpha = checkIconAlpha),
            modifier = Modifier
                .size(listItemResolveSize)
        )
    }

    LaunchedEffect(localIsResolved) {
        if (localIsResolved && !isResolved) {
            delay(TOGGLE_ANIMATION_DURATION_MS.toLong() + TOGGLE_ANIMATION_DELAY_MS.toLong())
            onToggle()
        }
    }
}

private const val ALPHA_VISIBLE = 1f
private const val ALPHA_HIDDEN = 0f
private const val TOGGLE_ANIMATION_DURATION_MS = 300
private const val TOGGLE_ANIMATION_DELAY_MS = 400
private const val CHECK_ICON_ALPHA_LABEL = "checkIconAlpha"
private const val TOGGLE_BORDER_ALPHA_LABEL = "toggleBorderAlpha"
private const val TOGGLE_TRANSITION_LABEL = "toggleTransition"
