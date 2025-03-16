package com.rafaelfelipeac.replyradar.app.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rafaelfelipeac.replyradar.app.navigation.Route.ReplyGraph
import com.rafaelfelipeac.replyradar.app.navigation.Route.ReplyList
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListScreenRoot
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.ReplyListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ReplyGraph
    ) {
        navigation<ReplyGraph>(
            startDestination = ReplyList
        ) {
            composable<ReplyList>(
                exitTransition = { slideOutHorizontally() },
                popEnterTransition = { slideInHorizontally() }
            ) {
                val viewModel = koinViewModel<ReplyListViewModel>()

                ReplyListScreenRoot(
                    viewModel = viewModel
                )
            }
        }
    }
}
