package com.rafaelfelipeac.replyradar.core.common.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ReplyRadarColors(
    val textFieldPlaceholderColor: Color,
    val buttonBorderColor: Color,
    val horizontalDividerColor: Color,
    val unselectedTabColor: Color,
    val toolbarIconsColor: Color,
    val snackbarBackgroundColor: Color,
    val replyBottomSheetIconColor: Color
)

val LocalReplyRadarColors = staticCompositionLocalOf<ReplyRadarColors> {
    error("No ReplyRadarColors provided.")
}
