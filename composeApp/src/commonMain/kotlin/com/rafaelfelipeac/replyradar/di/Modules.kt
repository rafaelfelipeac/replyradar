package com.rafaelfelipeac.replyradar.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.rafaelfelipeac.replyradar.reply.data.database.DatabaseFactory
import com.rafaelfelipeac.replyradar.reply.data.database.FavoriteReplyDatabase
import com.rafaelfelipeac.replyradar.reply.domain.ReplyRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.rafaelfelipeac.replyradar.reply.data.repository.ReplyRepositoryImpl
import com.rafaelfelipeac.replyradar.reply.presentation.reply_list.ReplyListViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import com.rafaelfelipeac.replyradar.reply.presentation.reply_detail.ReplyDetailViewModel
import com.rafaelfelipeac.replyradar.reply.presentation.SelectedReplyViewModel

expect val platformModule: Module

val sharedModule = module {
    singleOf(::ReplyRepositoryImpl).bind<ReplyRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteReplyDatabase>().replyDao }

    viewModelOf(::ReplyListViewModel)
    viewModelOf(::ReplyDetailViewModel)
    viewModelOf(::SelectedReplyViewModel)
}