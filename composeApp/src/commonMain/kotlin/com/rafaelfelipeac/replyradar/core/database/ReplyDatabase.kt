package com.rafaelfelipeac.replyradar.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafaelfelipeac.replyradar.features.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity

@Database(entities = [ReplyEntity::class], version = 1)
@ConstructedBy(ReplyDatabaseConstructor::class)
abstract class ReplyDatabase : RoomDatabase() {
    abstract val replyDao: ReplyDao
}
