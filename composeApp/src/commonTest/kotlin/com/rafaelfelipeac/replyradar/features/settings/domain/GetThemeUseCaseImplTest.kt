package com.rafaelfelipeac.replyradar.features.settings.domain

import app.cash.turbine.test
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.fakes.settings.data.FakeSettingsRepository
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class GetThemeUseCaseImplTest {

    @Test
    fun `getTheme should return value from repository`() = runTest {
        val fakeRepository = FakeSettingsRepository(theme = DARK)
        val useCase = GetThemeUseCaseImpl(fakeRepository)

        useCase.getTheme().test {
            assertEquals(DARK, awaitItem())
            awaitComplete()
        }
    }
}
