package com.rafaelfelipeac.replyradar.features.app.di

import com.rafaelfelipeac.replyradar.features.app.settings.AppSettingsViewModel
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCaseImpl
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AppSettingsViewModel(
            getThemeUseCase = get(),
            getLanguageUseCase = get()
        )
    }

    singleOf(::GetThemeUseCaseImpl).bind<GetThemeUseCase>()
    singleOf(::GetLanguageUseCaseImpl).bind<GetLanguageUseCase>()
}
