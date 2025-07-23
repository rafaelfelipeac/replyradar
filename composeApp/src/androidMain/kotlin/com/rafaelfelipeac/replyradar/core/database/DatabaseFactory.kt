package com.rafaelfelipeac.replyradar.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafaelfelipeac.replyradar.core.database.ReplyRadarMigrations.ALL_MIGRATIONS
import com.rafaelfelipeac.replyradar.core.util.AppConstants.DB_NAME

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<ReplyRadarDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(DB_NAME)

        return Room.databaseBuilder<ReplyRadarDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        ).addMigrations(*ALL_MIGRATIONS)
    }
}
