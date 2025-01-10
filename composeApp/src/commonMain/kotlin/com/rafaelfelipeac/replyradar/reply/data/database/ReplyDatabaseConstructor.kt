package com.rafaelfelipeac.replyradar.reply.data.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object ReplyDatabaseConstructor: RoomDatabaseConstructor<FavoriteReplyDatabase> {
    override fun initialize(): FavoriteReplyDatabase
}