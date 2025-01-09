package com.rafaelfelipeac.replyradar

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform