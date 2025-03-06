package com.rafaelfelipeac.replyradar.core.database

import androidx.room.RoomDatabase
import com.rafaelfelipeac.replyradar.reply.data.database.ReplyDatabase

expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<ReplyDatabase>
}