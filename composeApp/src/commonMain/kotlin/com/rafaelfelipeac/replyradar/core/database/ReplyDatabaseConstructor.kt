package com.rafaelfelipeac.replyradar.core.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object ReplyDatabaseConstructor: RoomDatabaseConstructor<ReplyDatabase> {
    override fun initialize(): ReplyDatabase
}
