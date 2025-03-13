package com.rafaelfelipeac.replyradar.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.rafaelfelipeac.replyradar.core.database.DatabaseFactory
import com.rafaelfelipeac.replyradar.core.database.ReplyDatabase
import com.rafaelfelipeac.replyradar.reply.domain.repository.ReplyRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import com.rafaelfelipeac.replyradar.reply.data.repository.ReplyRepositoryImpl
import com.rafaelfelipeac.replyradar.reply.domain.usecase.GetRepliesUseCase
import com.rafaelfelipeac.replyradar.reply.domain.usecase.UpsertReplyUseCase
import com.rafaelfelipeac.replyradar.reply.domain.usecase.UpsertReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.reply.domain.usecase.ToggleResolveReplyUseCase
import com.rafaelfelipeac.replyradar.reply.domain.usecase.ToggleResolveReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.reply.domain.usecase.GetRepliesUseCaseImpl
import com.rafaelfelipeac.replyradar.reply.domain.usecase.DeleteReplyUseCase
import com.rafaelfelipeac.replyradar.reply.domain.usecase.DeleteReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.ReplyListViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf

expect val platformModule: Module

val sharedModule = module {
    viewModelOf(::ReplyListViewModel)

    singleOf(::GetRepliesUseCaseImpl).bind<GetRepliesUseCase>()
    singleOf(::UpsertReplyUseCaseImpl).bind<UpsertReplyUseCase>()
    singleOf(::ToggleResolveReplyUseCaseImpl).bind<ToggleResolveReplyUseCase>()
    singleOf(::DeleteReplyUseCaseImpl).bind<DeleteReplyUseCase>()

    singleOf(::ReplyRepositoryImpl).bind<ReplyRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<ReplyDatabase>().replyDao }
}