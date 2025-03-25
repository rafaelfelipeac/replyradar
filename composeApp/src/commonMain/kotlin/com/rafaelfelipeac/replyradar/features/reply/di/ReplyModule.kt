package com.rafaelfelipeac.replyradar.features.reply.di

import com.rafaelfelipeac.replyradar.core.database.ReplyRadarDatabase
import com.rafaelfelipeac.replyradar.features.reply.data.repository.ReplyRepositoryImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.DeleteReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleArchiveReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleArchiveReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.ToggleResolveReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.UpsertReplyUseCaseImpl
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val replyModule = module {
    viewModel {
        ReplyListViewModel(
            upsertReplyUseCase = get(),
            toggleResolveReplyUseCase = get(),
            toggleArchiveReplyUseCase = get(),
            deleteReplyUseCase = get(),
            getRepliesUseCase = get(),
            logUserActionUseCase = get(),
            dispatcher = get()
        )
    }

    single<CoroutineDispatcher> { Dispatchers.IO }

    singleOf(::UpsertReplyUseCaseImpl).bind<UpsertReplyUseCase>()
    singleOf(::ToggleResolveReplyUseCaseImpl).bind<ToggleResolveReplyUseCase>()
    singleOf(::ToggleArchiveReplyUseCaseImpl).bind<ToggleArchiveReplyUseCase>()
    singleOf(::DeleteReplyUseCaseImpl).bind<DeleteReplyUseCase>()
    singleOf(::GetRepliesUseCaseImpl).bind<GetRepliesUseCase>()

    singleOf(::ReplyRepositoryImpl).bind<ReplyRepository>()

    single { get<ReplyRadarDatabase>().replyDao }
}
