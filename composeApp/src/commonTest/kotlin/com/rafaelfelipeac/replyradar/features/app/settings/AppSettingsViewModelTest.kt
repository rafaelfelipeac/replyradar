package com.rafaelfelipeac.replyradar.features.app.settings

import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage.PORTUGUESE
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.fakes.settings.domain.FakeGetLanguageUseCase
import com.rafaelfelipeac.replyradar.fakes.settings.domain.FakeGetThemeUseCase
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class AppSettingsViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private val getThemeUseCase = FakeGetThemeUseCase()
    private val getLanguageUseCase = FakeGetLanguageUseCase()

    @Test
    fun `ViewModel should expose correct theme and language`() = runTest {
        getThemeUseCase.theme = DARK
        getLanguageUseCase.language = PORTUGUESE

        val viewModel = AppSettingsViewModel(
            getThemeUseCase = getThemeUseCase,
            getLanguageUseCase = getLanguageUseCase
        )

        assertEquals(DARK, viewModel.theme.value)
        assertEquals(PORTUGUESE, viewModel.language.value)
    }
}
