package com.rafaelfelipeac.replyradar.features.settings.presentation

import app.cash.turbine.test
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.ENGLISH
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.fakes.settings.data.FakeSettingsRepository
import com.rafaelfelipeac.replyradar.fakes.useractions.domain.FakeLogUserActionUseCase
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetLanguageUseCaseImpl
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.GetThemeUseCaseImpl
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetLanguageUseCaseImpl
import com.rafaelfelipeac.replyradar.features.settings.domain.usecase.SetThemeUseCaseImpl
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectFeedback
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectLanguage
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectRate
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectTheme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Feedback
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Language
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Rate
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType.Theme
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Edit
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType.Open
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
class SettingsViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private val fakeRepository = FakeSettingsRepository()
    private val logUserActionUseCase = FakeLogUserActionUseCase()

    private lateinit var viewModel: SettingsViewModel

    @BeforeTest
    fun initViewModel() {
        viewModel = SettingsViewModel(
            getThemeUseCase = GetThemeUseCaseImpl(fakeRepository),
            setThemeUseCase = SetThemeUseCaseImpl(fakeRepository),
            getLanguageUseCase = GetLanguageUseCaseImpl(fakeRepository),
            setLanguageUseCase = SetLanguageUseCaseImpl(fakeRepository),
            logUserActionUseCase = logUserActionUseCase
        )
    }

    @Test
    fun `onSelectTheme should update state and log action`() = runTest {
        viewModel.onIntent(OnSelectTheme(DARK))

        viewModel.state.test {
            val state = awaitItem()
            assertEquals(DARK, state.theme)
            assertEquals(Edit, logUserActionUseCase.loggedActions.first().first)
            assertEquals(Theme, logUserActionUseCase.loggedActions.first().second)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `onSelectLanguage should update state and log action`() = runTest {
        viewModel.onIntent(OnSelectLanguage(ENGLISH))

        viewModel.state.test {
            val state = awaitItem()
            assertEquals(ENGLISH, state.language)
            assertEquals(Edit, logUserActionUseCase.loggedActions.first().first)
            assertEquals(Language, logUserActionUseCase.loggedActions.first().second)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `onSelectFeedback should log action`() = runTest {
        viewModel.onIntent(OnSelectFeedback)

        viewModel.state.test {
            assertEquals(Open, logUserActionUseCase.loggedActions.first().first)
            assertEquals(Feedback, logUserActionUseCase.loggedActions.first().second)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `onSelectRate should log action`() = runTest {
        viewModel.onIntent(OnSelectRate)

        viewModel.state.test {
            assertEquals(Open, logUserActionUseCase.loggedActions.first().first)
            assertEquals(Rate, logUserActionUseCase.loggedActions.first().second)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
