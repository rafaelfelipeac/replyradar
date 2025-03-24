package com.rafaelfelipeac.replyradar.core.database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.rafaelfelipeac.replyradar.core.AppConstants.DB_NAME
import java.io.File

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<ReplyRadarDatabase> {
        val os = System.getProperty("os.name").lowercase()
        val userHome = System.getProperty("user.home")
        val appDataDir = when {
            os.contains("win") -> File(System.getenv("APPDATA"), "ReplyRadar")
            os.contains("mac") -> File(userHome, "Library/Application Support/ReplyRadar")
            else -> File(userHome, ".local/share/ReplyRadar")
        }

        if(!appDataDir.exists()) {
            appDataDir.mkdirs()
        }

        val dbFile = File(appDataDir, DB_NAME)
        return Room.databaseBuilder(dbFile.absolutePath)
    }
}