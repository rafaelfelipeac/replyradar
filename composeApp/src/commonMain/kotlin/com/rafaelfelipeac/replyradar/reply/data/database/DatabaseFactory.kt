package com.rafaelfelipeac.replyradar.reply.data.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<FavoriteReplyDatabase>
}