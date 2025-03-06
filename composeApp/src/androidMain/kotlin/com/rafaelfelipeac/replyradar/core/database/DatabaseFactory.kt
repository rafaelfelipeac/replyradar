package com.rafaelfelipeac.replyradar.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafaelfelipeac.replyradar.reply.data.database.ReplyDatabase
import com.rafaelfelipeac.replyradar.reply.data.database.ReplyDatabase.Companion.DB_NAME

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<ReplyDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(DB_NAME)

        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}