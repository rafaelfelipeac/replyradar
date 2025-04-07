package com.rafaelfelipeac.replyradar.features.settings.domain

import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.fakes.settings.data.FakeSettingsRepository
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetThemeUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class SetThemeUseCaseTest {

    private val fakeSettingsRepository = FakeSettingsRepository()
    private val setThemeUseCase = SetThemeUseCaseImpl(fakeSettingsRepository)

    @Test
    fun `setTheme should update theme in repository`() = runTest {
        val theme = DARK

        setThemeUseCase.setTheme(theme)

        assertEquals(theme, fakeSettingsRepository.theme)
    }
}
