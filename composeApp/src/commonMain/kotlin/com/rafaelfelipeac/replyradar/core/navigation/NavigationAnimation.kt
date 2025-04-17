package com.rafaelfelipeac.replyradar.core.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally

object NavigationAnimation {

    fun enter(): EnterTransition = slideInHorizontally(initialOffsetX = { it })

    fun exit(): ExitTransition = slideOutHorizontally(targetOffsetX = { -it })

    fun popEnter(): EnterTransition = slideInHorizontally(initialOffsetX = { -it })

    fun popExit(): ExitTransition = slideOutHorizontally(targetOffsetX = { it })
}
