package com.rafaelfelipeac.replyradar.features.activitylog.di

import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogViewModel
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.GetUserActionItemsUseCase
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.GetUserActionItemsUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val activityLogModule = module {
    viewModel {
        ActivityLogViewModel(
            getUserActionItemsUseCase = get()
        )
    }

    singleOf(::GetUserActionItemsUseCaseImpl).bind<GetUserActionItemsUseCase>()
}
