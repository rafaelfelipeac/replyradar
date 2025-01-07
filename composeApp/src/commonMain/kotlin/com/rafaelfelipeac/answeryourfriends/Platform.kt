package com.rafaelfelipeac.answeryourfriends

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform