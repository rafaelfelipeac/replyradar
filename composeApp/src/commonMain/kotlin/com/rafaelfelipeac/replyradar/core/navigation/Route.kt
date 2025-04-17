package com.rafaelfelipeac.replyradar.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object ReplyGraph : Route

    @Serializable
    data object ReplyList : Route

    @Serializable
    data object Settings : Route

    @Serializable
    data object ActivityLog : Route
}
