package com.rafaelfelipeac.replyradar.core.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.rafaelfelipeac.replyradar.features.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity
import com.rafaelfelipeac.replyradar.features.useractions.data.database.dao.UserActionDao
import com.rafaelfelipeac.replyradar.features.useractions.data.database.entity.UserActionEntity

@Database(entities = [ReplyEntity::class, UserActionEntity::class], version = DATABASE_VERSION)
@ConstructedBy(ReplyDatabaseConstructor::class)
abstract class ReplyDatabase : RoomDatabase() {
    abstract val replyDao: ReplyDao
    abstract val userActionDao: UserActionDao
}

private const val DATABASE_VERSION = 1
