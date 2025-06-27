package com.rafaelfelipeac.replyradar.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafaelfelipeac.replyradar.core.util.AppConstants.DB_NAME
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<ReplyRadarDatabase> {
        val dbFile = documentDirectory() + "/$DB_NAME"
        return Room.databaseBuilder<ReplyRadarDatabase>(
            name = dbFile
        )
    }

    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        return requireNotNull(documentDirectory?.path)
    }
}
