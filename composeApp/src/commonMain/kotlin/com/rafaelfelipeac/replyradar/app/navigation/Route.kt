package com.rafaelfelipeac.replyradar.app.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object ReplyGraph : Route

    @Serializable
    data object ReplyList : Route

    @Serializable
    data object Settings : Route
}
