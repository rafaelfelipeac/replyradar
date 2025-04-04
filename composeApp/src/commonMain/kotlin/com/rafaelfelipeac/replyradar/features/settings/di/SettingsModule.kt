package com.rafaelfelipeac.replyradar.features.settings.di

import com.rafaelfelipeac.replyradar.features.settings.data.repository.SettingsRepositoryImpl
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCaseImpl
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetThemeUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetThemeUseCaseImpl
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

var settingsModule = module {
    viewModel {
        SettingsViewModel(
            getThemeUseCase = get(),
            setThemeUseCase = get()
        )
    }

    singleOf(::GetThemeUseCaseImpl).bind<GetThemeUseCase>()
    singleOf(::SetThemeUseCaseImpl).bind<SetThemeUseCase>()

    singleOf(::SettingsRepositoryImpl).bind<SettingsRepository>()
}
