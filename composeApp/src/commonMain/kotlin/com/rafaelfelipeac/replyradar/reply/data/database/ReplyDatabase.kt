package com.rafaelfelipeac.replyradar.reply.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.rafaelfelipeac.replyradar.core.database.StringListTypeConverter
import com.rafaelfelipeac.replyradar.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.reply.data.database.entity.ReplyEntity

@Database(
    entities = [ReplyEntity::class],
    version = 1
)
@TypeConverters(StringListTypeConverter::class)
@ConstructedBy(ReplyDatabaseConstructor::class)
abstract class ReplyDatabase: RoomDatabase() {
    abstract val replyDao: ReplyDao

    companion object {
        const val DB_NAME = "replyradar.db"
    }
}

// wrong package?