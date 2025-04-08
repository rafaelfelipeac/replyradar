package com.rafaelfelipeac.replyradar.features.reply.presentation

import app.cash.turbine.test
import com.rafaelfelipeac.replyradar.ARCHIVE
import com.rafaelfelipeac.replyradar.CREATE
import com.rafaelfelipeac.replyradar.DELETE
import com.rafaelfelipeac.replyradar.EDIT
import com.rafaelfelipeac.replyradar.RESOLVE
import com.rafaelfelipeac.replyradar.dropFirst
import com.rafaelfelipeac.replyradar.fakes.reply.domain.FakeDeleteReplyUseCase
import com.rafaelfelipeac.replyradar.fakes.reply.domain.FakeGetRepliesUseCase
import com.rafaelfelipeac.replyradar.fakes.reply.domain.FakeToggleArchiveReplyUseCase
import com.rafaelfelipeac.replyradar.fakes.reply.domain.FakeToggleResolveReplyUseCase
import com.rafaelfelipeac.replyradar.fakes.reply.domain.FakeUpsertReplyUseCase
import com.rafaelfelipeac.replyradar.fakes.useractions.domain.FakeLogUserActionUseCase
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnAddReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDeleteReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnDismissBottomSheet
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnEditReply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleArchive
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyBottomSheetIntent.OnToggleResolve
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnAddReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnReplyClick
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenIntent.ReplyListIntent.OnTabSelected
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListViewModel
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListViewModel.Companion.ERROR_GET_REPLIES
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetState
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class ReplyListViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()

    @BeforeTest
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private val upsertReplyUseCase = FakeUpsertReplyUseCase()
    private val toggleResolveReplyUseCase = FakeToggleResolveReplyUseCase()
    private val toggleArchiveReplyUseCase = FakeToggleArchiveReplyUseCase()
    private val deleteReplyUseCase = FakeDeleteReplyUseCase()
    private val getRepliesUseCase = FakeGetRepliesUseCase()
    private val logUserActionUseCase = FakeLogUserActionUseCase()

    private val viewModel = ReplyListViewModel(
        upsertReplyUseCase = upsertReplyUseCase,
        toggleResolveReplyUseCase = toggleResolveReplyUseCase,
        toggleArchiveReplyUseCase = toggleArchiveReplyUseCase,
        deleteReplyUseCase = deleteReplyUseCase,
        getRepliesUseCase = getRepliesUseCase,
        logUserActionUseCase = logUserActionUseCase,
        dispatcher = testDispatcher
    )

    private val sampleReply = Reply(
        id = 1L,
        name = "Name",
        subject = "Subject"
    )

    @Test
    fun `OnAddReplyClick should open bottom sheet in CREATE mode`() = runTest {
        viewModel.state.drop(dropFirst).test {
            viewModel.onIntent(OnAddReplyClick)

            val updatedState = awaitItem()
            val expectedState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.CREATE
            )

            assertEquals(expectedState, updatedState.replyBottomSheetState)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `OnReplyClick should open bottom sheet in EDIT mode with reply`() = runTest {
        viewModel.state.drop(dropFirst).test {
            viewModel.onIntent(OnReplyClick(sampleReply))

            val updatedState = awaitItem()
            val expectedState = ReplyBottomSheetState(
                replyBottomSheetMode = ReplyBottomSheetMode.EDIT,
                reply = sampleReply
            )

            assertEquals(expectedState, updatedState.replyBottomSheetState)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `OnTabSelected should update selectedTabIndex`() = runTest {
        viewModel.state.drop(dropFirst).test {
            viewModel.onIntent(OnTabSelected(2))

            val updatedState = awaitItem()
            assertEquals(2, updatedState.selectedTabIndex)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `OnAddReply should upsert reply log action and dismiss bottom sheet`() = runTest {
        viewModel.state.test {
            viewModel.onIntent(OnAddReply(sampleReply))

            val updatedState = awaitItem()
            assertEquals(null, updatedState.replyBottomSheetState)
            assertEquals(sampleReply, upsertReplyUseCase.insertedReplies.first())
            assertEquals(CREATE, logUserActionUseCase.loggedActions.first().first.value)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `OnEditReply should upsert reply log action and dismiss bottom sheet`() = runTest {
        viewModel.state.test {
            viewModel.onIntent(OnEditReply(sampleReply))

            val updatedState = awaitItem()
            assertEquals(null, updatedState.replyBottomSheetState)
            assertEquals(sampleReply, upsertReplyUseCase.insertedReplies.first())
            assertEquals(EDIT, logUserActionUseCase.loggedActions.first().first.value)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `OnDeleteReply should delete reply log action and dismiss bottom sheet`() = runTest {
        viewModel.state.test {
            viewModel.onIntent(OnDeleteReply(sampleReply))

            val updatedState = awaitItem()
            assertEquals(null, updatedState.replyBottomSheetState)
            assertEquals(sampleReply, deleteReplyUseCase.deletedReplies.first())
            assertEquals(DELETE, logUserActionUseCase.loggedActions.first().first.value)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `OnToggleArchive should toggle archive log correct action and dismiss bottom sheet`() =
        runTest {
            viewModel.state.test {
                viewModel.onIntent(OnToggleArchive(sampleReply))

                val updatedState = awaitItem()
                assertEquals(null, updatedState.replyBottomSheetState)
                assertEquals(sampleReply, toggleArchiveReplyUseCase.toggledReplies.first())
                assertEquals(ARCHIVE, logUserActionUseCase.loggedActions.first().first.value)
                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `OnToggleResolve should toggle resolve log correct action and dismiss bottom sheet`() =
        runTest {
            viewModel.state.test {
                viewModel.onIntent(OnToggleResolve(sampleReply))

                val updatedState = awaitItem()
                assertEquals(null, updatedState.replyBottomSheetState)
                assertEquals(sampleReply, toggleResolveReplyUseCase.toggledReplies.first())
                assertEquals(RESOLVE, logUserActionUseCase.loggedActions.first().first.value)
                cancelAndIgnoreRemainingEvents()
            }
        }

    @Test
    fun `OnDismissBottomSheet should clear bottom sheet state`() = runTest {
        viewModel.state.test {
            viewModel.onIntent(OnDismissBottomSheet)

            val updatedState = awaitItem()
            assertEquals(null, updatedState.replyBottomSheetState)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `ViewModel should emit replies resolved-replies and archived-replies on start`() = runTest {
        val reply = sampleReply
        val resolved = reply.copy(id = 2L)
        val archived = reply.copy(id = 3L)

        getRepliesUseCase.replies = listOf(reply)
        getRepliesUseCase.resolvedReplies = listOf(resolved)
        getRepliesUseCase.archivedReplies = listOf(archived)

        val viewModel = ReplyListViewModel(
            upsertReplyUseCase = upsertReplyUseCase,
            toggleResolveReplyUseCase = toggleResolveReplyUseCase,
            toggleArchiveReplyUseCase = toggleArchiveReplyUseCase,
            deleteReplyUseCase = deleteReplyUseCase,
            getRepliesUseCase = getRepliesUseCase,
            logUserActionUseCase = logUserActionUseCase,
            dispatcher = testDispatcher
        )

        viewModel.state.test {
            val state = awaitItem()

            assertEquals(listOf(reply), state.replies)
            assertEquals(listOf(resolved), state.resolvedReplies)
            assertEquals(listOf(archived), state.archivedReplies)

            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `ViewModel should emit error message if getReplies fails`() = runTest {
        getRepliesUseCase.shouldThrow = true

        val viewModel = ReplyListViewModel(
            upsertReplyUseCase = upsertReplyUseCase,
            toggleResolveReplyUseCase = toggleResolveReplyUseCase,
            toggleArchiveReplyUseCase = toggleArchiveReplyUseCase,
            deleteReplyUseCase = deleteReplyUseCase,
            getRepliesUseCase = getRepliesUseCase,
            logUserActionUseCase = logUserActionUseCase,
            dispatcher = testDispatcher
        )

        viewModel.state.test {
            val state = awaitItem()
            assertEquals(ERROR_GET_REPLIES, state.errorMessage)
            cancelAndIgnoreRemainingEvents()
        }
    }
}
