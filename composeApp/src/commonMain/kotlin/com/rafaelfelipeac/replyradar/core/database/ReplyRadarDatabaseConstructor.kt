package com.rafaelfelipeac.replyradar.core.database

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object ReplyRadarDatabaseConstructor : RoomDatabaseConstructor<ReplyRadarDatabase> {
    override fun initialize(): ReplyRadarDatabase
}
