package com.rafaelfelipeac.replyradar.features.settings.domain

import app.cash.turbine.test
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.PORTUGUESE
import com.rafaelfelipeac.replyradar.fakes.settings.data.FakeSettingsRepository
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCaseImpl
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class GetLanguageUseCaseImplTest {

    @Test
    fun `getLanguage should return value from repository`() = runTest {
        val fakeRepository = FakeSettingsRepository(language = PORTUGUESE)
        val useCase = GetLanguageUseCaseImpl(fakeRepository)

        useCase.getLanguage().test {
            assertEquals(PORTUGUESE, awaitItem())
            awaitComplete()
        }
    }
}
