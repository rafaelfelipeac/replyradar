package com.rafaelfelipeac.replyradar.app

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.rafaelfelipeac.replyradar.reply.presentation.SelectedReplyViewModel
import com.rafaelfelipeac.replyradar.reply.presentation.reply_detail.ReplyDetailScreenRoot
import com.rafaelfelipeac.replyradar.reply.presentation.reply_detail.ReplyDetailAction
import com.rafaelfelipeac.replyradar.reply.presentation.reply_detail.ReplyDetailViewModel
import com.rafaelfelipeac.replyradar.reply.presentation.reply_list.ReplyListScreenRoot
import com.rafaelfelipeac.replyradar.reply.presentation.reply_list.ReplyListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.ReplyGraph
        ) {
            navigation<Route.ReplyGraph>(
                startDestination = Route.ReplyList
            ) {
                composable<Route.ReplyList>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    val viewModel = koinViewModel<ReplyListViewModel>()
                    val selectedReplyViewModel =
                        it.sharedKoinViewModel<SelectedReplyViewModel>(navController)

                    LaunchedEffect(true) {
                        selectedReplyViewModel.onSelectReply(null)
                    }

                    ReplyListScreenRoot(
                        viewModel = viewModel,
                        onReplyClick = { reply ->
                            selectedReplyViewModel.onSelectReply(reply)
                            navController.navigate(
                                Route.ReplyDetail(reply.id)
                            )
                        }
                    )
                }
                composable<Route.ReplyDetail>(
                    enterTransition = { slideInHorizontally { initialOffset ->
                        initialOffset
                    } },
                    exitTransition = { slideOutHorizontally { initialOffset ->
                        initialOffset
                    } }
                ) {
                    val selectedReplyViewModel =
                        it.sharedKoinViewModel<SelectedReplyViewModel>(navController)
                    val viewModel = koinViewModel<ReplyDetailViewModel>()
                    val selectedReply by selectedReplyViewModel.selectedReply.collectAsStateWithLifecycle()

                    LaunchedEffect(selectedReply) {
                        selectedReply?.let {
                            viewModel.onAction(ReplyDetailAction.OnSelectedReplyChange(it))
                        }
                    }

                    ReplyDetailScreenRoot()
                }
            }
        }

    }
}

@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}
