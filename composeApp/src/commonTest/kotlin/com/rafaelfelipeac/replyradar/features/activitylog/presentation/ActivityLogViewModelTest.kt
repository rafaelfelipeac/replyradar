package com.rafaelfelipeac.replyradar.features.activitylog.presentation

import app.cash.turbine.test
import com.rafaelfelipeac.replyradar.fakes.useractions.domain.FakeGetUserActionItemsUseCase
import com.rafaelfelipeac.replyradar.features.activitylog.presentation.ActivityLogViewModel.Companion.ERROR_GET_ACTIVITY_LOG
import com.rafaelfelipeac.replyradar.sampleUserAction
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
class ActivityLogViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private val getUserActionItemsUseCase = FakeGetUserActionItemsUseCase()

    @Test
    fun `ViewModel should emit user actions on start`() = runTest {
        val userAction = sampleUserAction
        getUserActionItemsUseCase.userActions = listOf(userAction)

        val viewModel = ActivityLogViewModel(getUserActionItemsUseCase)

        viewModel.state.test {
            val state = awaitItem()
            assertEquals(listOf(userAction), state.activityLogItems)
            assertEquals(false, state.isLoading)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `ViewModel should emit error message if getUserActions fails`() = runTest {
        getUserActionItemsUseCase.shouldThrow = true

        val viewModel = ActivityLogViewModel(getUserActionItemsUseCase)

        viewModel.state.test {
            val state = awaitItem()
            assertEquals(ERROR_GET_ACTIVITY_LOG, state.errorMessage)
            assertEquals(false, state.isLoading)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
