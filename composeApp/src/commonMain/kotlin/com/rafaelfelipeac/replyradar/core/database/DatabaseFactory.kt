package com.rafaelfelipeac.replyradar.core.database

import androidx.room.RoomDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<ReplyRadarDatabase>
}