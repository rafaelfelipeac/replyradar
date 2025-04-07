package com.rafaelfelipeac.replyradar.features.settings.domain

import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage.PORTUGUESE
import com.rafaelfelipeac.replyradar.fakes.settings.data.FakeSettingsRepository
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetLanguageUseCaseImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SetLanguageUseCaseTest {

    private val fakeSettingsRepository = FakeSettingsRepository()
    private val setLanguageUseCase = SetLanguageUseCaseImpl(fakeSettingsRepository)

    @Test
    fun `setLanguage should update language in repository`() = runTest {
        val language = PORTUGUESE

        setLanguageUseCase.setLanguage(language)

        assertEquals(language, fakeSettingsRepository.language)
    }
}
