package com.rafaelfelipeac.replyradar.features.reply.di

import com.rafaelfelipeac.replyradar.core.database.ReplyDatabase
import com.rafaelfelipeac.replyradar.features.reply.data.repository.ReplyRepositoryImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val replyModule = module {
    viewModelOf(::ReplyListViewModel)

    singleOf(::GetRepliesUseCaseImpl).bind<GetRepliesUseCase>()
    singleOf(::UpsertReplyUseCaseImpl).bind<UpsertReplyUseCase>()
    singleOf(::ToggleResolveReplyUseCaseImpl).bind<ToggleResolveReplyUseCase>()
    singleOf(::DeleteReplyUseCaseImpl).bind<DeleteReplyUseCase>()

    singleOf(::ReplyRepositoryImpl).bind<ReplyRepository>()

    single { get<ReplyDatabase>().replyDao }
}
