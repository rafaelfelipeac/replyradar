package com.rafaelfelipeac.replyradar.core.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL

object ReplyRadarMigrations {
    val ALL_MIGRATIONS = arrayOf(MIGRATION_1_2)
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE replies ADD COLUMN reminderAt INTEGER NOT NULL DEFAULT 0")
    }

    override fun migrate(connection: SQLiteConnection) {
        connection.execSQL("ALTER TABLE replies ADD COLUMN reminderAt INTEGER NOT NULL DEFAULT 0")
    }
}

