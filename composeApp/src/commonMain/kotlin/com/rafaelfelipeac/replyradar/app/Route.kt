package com.rafaelfelipeac.replyradar.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object ReplyGraph: Route

    @Serializable
    data object ReplyList: Route

    @Serializable
    data class ReplyDetail(val id: String): Route
}