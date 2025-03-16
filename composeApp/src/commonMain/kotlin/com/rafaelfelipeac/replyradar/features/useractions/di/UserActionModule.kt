package com.rafaelfelipeac.replyradar.features.useractions.di

import com.rafaelfelipeac.replyradar.core.database.ReplyDatabase
import com.rafaelfelipeac.replyradar.features.useractions.data.repository.UserActionRepositoryImpl
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCase
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.LogUserActionUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val userActionModule = module {
    singleOf(::LogUserActionUseCaseImpl).bind<LogUserActionUseCase>()

    singleOf(::UserActionRepositoryImpl).bind<UserActionRepository>()

    single { get<ReplyDatabase>().userActionDao }
}
